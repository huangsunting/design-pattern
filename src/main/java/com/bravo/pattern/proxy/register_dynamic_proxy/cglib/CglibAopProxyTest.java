package com.bravo.pattern.proxy.register_dynamic_proxy.cglib;

import com.bravo.pattern.proxy.register_dynamic_proxy.cglib.aop.ApplicationContext;
import com.bravo.pattern.proxy.register_dynamic_proxy.cglib.target.UserService;

public class CglibAopProxyTest {
    public static void main(String[] args) {
        String beanPath = "com.bravo.pattern.proxy.register_dynamic_proxy.cglib.target.UserService";

        ApplicationContext applicationContext = new ApplicationContext();
        UserService userService = (UserService) applicationContext.getBean(beanPath);// cglib并非基于接口，这里如果强转IService会报错
        userService.register("bravo1988", "18257555555", "male");
    }
}
