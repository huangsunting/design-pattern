package com.bravo.pattern.proxy.jdk_proxy_demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {

    public static void main(String[] args) {
        // 目标对象
        CalculatorImpl targetObj = new CalculatorImpl();
        // 代理对象
        Calculator proxyCalculator = (Calculator) Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),   /*类加载器（随意）：用来加载动态生成的代理类*/
                new Class[]{Calculator.class},       /*接口：为该接口生成代理类*/
                new InvocationHandler() {            /*具体的代理逻辑*/
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before " + method.getName());
                        Object result = method.invoke(targetObj, args); // 执行目标方法，得到执行结果
                        System.out.println("after " + method.getName());
                        return result;
                    }
                }
        );
        // System.out.println(proxyCalculator.getClass().getSimpleName());
        System.out.println("执行结果：" + proxyCalculator.add(1, 2));
    }

    // 接口
    interface Calculator {
        int add(int a, int b);
    }

    // 目标类
    static class CalculatorImpl implements Calculator {
        @Override
        public int add(int a, int b) {
            System.out.println("invoke add(a=" + a + " b=" + b + ")");
            return a + b;
        }
    }
}