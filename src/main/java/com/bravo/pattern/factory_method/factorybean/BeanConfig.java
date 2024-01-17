package com.bravo.pattern.factory_method.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public MyBeanFactory myBeanFactory() {
        return new MyBeanFactory();
    }
}
