package com.bravo.pattern.proxy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class InjectTest {

    @Resource
    private MyServiceImpl myServiceImpl;

    @Test
    public void test() {
        myServiceImpl.doSomething();
    }
}
