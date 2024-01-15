package com.bravo.pattern.factorymethod.factorybean;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class FactoryBeanTest {

    @Resource
    private MyBean myBean;

    @Test
    public void test() {
        System.out.println(myBean);
    }

}
