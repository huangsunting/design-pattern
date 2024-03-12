package com.bravo.other.ioc.container;

import com.bravo.other.ioc.container.scanner.ClassPathBeanDefinitionScanner;
import org.springframework.beans.BeansException;

/**
 * 在Spring中，ApplicationContext是一个接口。
 * 继承了BeanFactory（容器能力）、ResourceLoader（资源加载能力）、ApplicationEventPublisher（事件发布能力）等接口。
 * 这里简化为具体实现类，但它仍然具备BeanFactory以及ResourceLoader的能力。
 */
public class ApplicationContext {

    // 组合BeanFactory
    private BeanFactory beanFactory;

    public ApplicationContext(String... backPackages) {
        refresh(backPackages);
    }

    private void refresh(String... backPackages) {
        // 创建BeanFactory，并加载BeanDefinition
        beanFactory = obtainFreshBeanFactory(backPackages);

        // 提前实例化单例bean
        beanFactory.preInstantiateSingletons();
    }

    private BeanFactory obtainFreshBeanFactory(String... backPackages) {
        // 其实就是把BeanFactoryTest中的@BeforeEach的逻辑搬到这里
        BeanFactory beanFactory = new BeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.doScan(backPackages);
        return beanFactory;
    }


    /******** ApplicationContext的容器能力都是借助BeanFactory实现的 *******/

    public Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return ((T) getBean(name));
    }
}
