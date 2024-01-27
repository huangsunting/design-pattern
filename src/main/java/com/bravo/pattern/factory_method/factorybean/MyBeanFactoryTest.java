package com.bravo.pattern.factory_method.factorybean;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MyBeanFactoryTest {

    // 注入MyBean类型的Bean
    @Resource
    private MyBean myBean1;

    // 注入myBeanFactory创建的Bean
    @Resource(name = "myBeanFactory")
    private MyBean myBean2;

    // 注入myBeanFactory
    @Resource(name = "&myBeanFactory")
    private MyBeanFactory myBeanFactory;

    @Test
    public void test() {
        System.out.println(myBean1);
        System.out.println(myBean2);
        System.out.println(myBeanFactory);
    }

}
