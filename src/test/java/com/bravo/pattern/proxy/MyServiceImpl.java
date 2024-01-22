package com.bravo.pattern.proxy;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MyServiceImpl {

    @Transactional
    public void doSomething() {
        System.out.println("MyServiceImpl this：" + this);
    }

}
