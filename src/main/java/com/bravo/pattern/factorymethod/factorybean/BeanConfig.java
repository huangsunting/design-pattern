package com.bravo.pattern.factorymethod.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public MyBeanFactory myBeanFactory() {
        return new MyBeanFactory();
    }
}
