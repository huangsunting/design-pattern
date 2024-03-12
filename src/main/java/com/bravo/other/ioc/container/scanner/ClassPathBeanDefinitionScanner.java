package com.bravo.other.ioc.container.scanner;

import cn.hutool.core.util.StrUtil;
import com.bravo.other.ioc.container.BeanFactory;
import com.bravo.other.ioc.container.annotation.Component;
import com.bravo.other.ioc.container.annotation.Scope;
import com.bravo.other.ioc.container.beandefinition.BeanDefinition;

import java.util.Set;

/**
 * BeanDefinition扫描器
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

	private final BeanFactory registry;

	public ClassPathBeanDefinitionScanner(BeanFactory registry) {
		this.registry = registry;
	}

	public void doScan(String... basePackages) {
		for (String basePackage : basePackages) {
			Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
			// 补充BeanDefinition其它信息
			for (BeanDefinition candidate : candidates) {
				String beanScope = resolveBeanScope(candidate);
				if (StrUtil.isNotEmpty(beanScope)) {
					candidate.setScope(beanScope);
				}
				String beanName = determineBeanName(candidate);
				// 注册到BeanFactory
				registry.registerBeanDefinition(beanName, candidate);
			}
		}
	}

	private String resolveBeanScope(BeanDefinition beanDefinition) {
		Class<?> beanClass = beanDefinition.getBeanClass();
		Scope scope = beanClass.getAnnotation(Scope.class);
		if (scope != null) {
			return scope.value();
		}
		return StrUtil.EMPTY;
	}


	private String determineBeanName(BeanDefinition beanDefinition) {
		Class<?> beanClass = beanDefinition.getBeanClass();
		Component component = beanClass.getAnnotation(Component.class);
		String value = component.value();
		if (StrUtil.isEmpty(value)) {
			value = StrUtil.lowerFirst(beanClass.getSimpleName());
		}
		return value;
	}
}
