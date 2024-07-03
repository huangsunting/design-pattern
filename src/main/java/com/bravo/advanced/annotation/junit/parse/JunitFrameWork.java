package com.bravo.advanced.annotation.junit.parse;

import com.bravo.advanced.annotation.junit.define.After;
import com.bravo.advanced.annotation.junit.define.Before;
import com.bravo.advanced.annotation.junit.define.Test;
import com.bravo.advanced.annotation.junit.use.UserTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解三部曲
 * - 定义注解（@Test/@Before/@After）
 * - 使用注解（UserTest）
 * - 解析注解（JunitFrameWork）
 * 本来应该由UserTest触发测试案例，但这毕竟不是真的Junit框架，需要自己执行JunitFrameWork#main
 */
public class JunitFrameWork {

    public static void main(String[] args) throws Exception {
        // 1.反射创建测试案例对象
        Class<?> clazz = UserTest.class;
        Object obj = clazz.newInstance();

        // 2.获取UserTest类中所有公共方法
        Method[] methods = clazz.getMethods();

        // 3.迭代出每一个Method对象，判断哪些方法上使用了@Before/@After/@Test注解
        List<Method> myBeforeList = new ArrayList<>();
        List<Method> myAfterList = new ArrayList<>();
        List<Method> myTestList = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Before.class)) {
                // 存储使用了@Before注解的方法对象
                myBeforeList.add(method);
            } else if (method.isAnnotationPresent(Test.class)) {
                // 存储使用了@Test注解的方法对象
                myTestList.add(method);
            } else if (method.isAnnotationPresent(After.class)) {
                // 存储使用了@After注解的方法对象
                myAfterList.add(method);
            }
        }

        // 执行待测试方法：myTestList
        for (Method testMethod : myTestList) {
            // 先执行@Before
            for (Method beforeMethod : myBeforeList) {
                beforeMethod.invoke(obj);
            }

            // 再执行@Test
            testMethod.invoke(obj);

            // 最后执行@After
            for (Method afterMethod : myAfterList) {
                afterMethod.invoke(obj);
            }
        }
    }
}