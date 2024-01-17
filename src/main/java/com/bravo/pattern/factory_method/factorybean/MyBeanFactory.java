package com.bravo.pattern.factory_method.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class MyBeanFactory implements FactoryBean<MyBean> {

    @Override
    public MyBean getObject() throws Exception {
        return new MyBean("Hello from FactoryBean in Spring Boot!");
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
