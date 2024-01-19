package com.bravo.pattern.proxy.register_dynamic_proxy.jdk;

import com.bravo.pattern.proxy.register_dynamic_proxy.jdk.aop.ApplicationContext;
import com.bravo.pattern.proxy.register_dynamic_proxy.jdk.target.IUserService;

public class JdkAopProxyTest {
    public static void main(String[] args) {
        String beanPath = "com.bravo.pattern.proxy.register_dynamic_proxy.jdk.target.UserService";

        ApplicationContext applicationContext = new ApplicationContext();
        IUserService userService = (IUserService) applicationContext.getBean(beanPath);
        userService.register("bravo1988", "18257555555", "male");
    }
}