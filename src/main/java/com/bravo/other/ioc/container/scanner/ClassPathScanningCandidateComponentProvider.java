package com.bravo.other.ioc.container.scanner;

import cn.hutool.core.util.ClassUtil;
import com.bravo.other.ioc.container.annotation.Component;
import com.bravo.other.ioc.container.beandefinition.BeanDefinition;

import java.util.LinkedHashSet;
import java.util.Set;


public class ClassPathScanningCandidateComponentProvider {

    // 扫描有Component注解的类，并将其封装成BeanDefinition对象
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            candidates.add(beanDefinition);
        }
        return candidates;
    }
}
