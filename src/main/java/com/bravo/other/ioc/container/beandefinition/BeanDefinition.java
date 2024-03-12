package com.bravo.other.ioc.container.beandefinition;

/**
 * Spring的核心概念之一，定义了如何创建一个Bean，包括Bean的类（beanClass）、属性值（propertyValues）、是否单例、生命周期方法等。
 *
 * 为什么需要额外定义一个BeanDefinition，难道不是多此一举？非也。Spring作为IoC容器，可以帮我们管理对象的创建、赋值（注入）、销毁等。
 * 这些被Spring托管的对象被称为Bean。引入Spring后，对Bean的主导权由程序员转移到了框架，即所谓的控制反转。
 * 但Spring也不是这么无情，虽然Bean的创建权被它剥夺了，但Spring对外暴露了BeanDefinition抽象，我们可以通过BeanDefinition指导Spring如何创建一个Bean。
 * 相当于塞给Spring一张说明书：哥，你看这道菜能帮我做一下吗？（紧张地搓手手）
 *
 * 不论是XML的Bean标签、@Component还是@Bean，本质都是为了定义一个BeanDefinition，然后最终由Spring根据BeanDefinition创建Bean。
 */
public class BeanDefinition {
    /******* 常量 *******/
    public static String SCOPE_SINGLETON = "singleton";
    public static String SCOPE_PROTOTYPE = "prototype";

    /******* Bean定义信息 *******/
    private Class<?> beanClass;
    private boolean singleton = true;
    private boolean prototype = false;
    private boolean lazyInit = false;
    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public void setScope(String scope) {
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public boolean isSingleton() {
        return this.singleton;
    }

    public boolean isPrototype() {
        return this.prototype;
    }

    public void setLazyInit(boolean b) {
        lazyInit = b;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

}
