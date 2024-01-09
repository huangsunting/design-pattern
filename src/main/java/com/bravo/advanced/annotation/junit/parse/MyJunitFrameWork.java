package com.bravo.advanced.annotation.junit.parse;

import com.bravo.advanced.annotation.junit.define.MyAfter;
import com.bravo.advanced.annotation.junit.define.MyBefore;
import com.bravo.advanced.annotation.junit.define.MyTest;
import com.bravo.advanced.annotation.junit.use.UserTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个就是注解三部曲中最重要的：读取并解析
 * 相当于我们使用Junit时看不见的那部分（在隐秘的角落里帮我们执行标注了@Test的方法）
 */
public class MyJunitFrameWork {

    public static void main(String[] args) throws Exception {
        // 1.反射创建测试案例对象
        Class<?> clazz = UserTest.class;
        Object obj = clazz.newInstance();

        // 2.获取UserTest类中所有公共方法
        Method[] methods = clazz.getMethods();

        // 3.迭代出每一个Method对象，判断哪些方法上使用了@MyBefore/@MyAfter/@MyTest注解
        List<Method> myBeforeList = new ArrayList<>();
        List<Method> myAfterList = new ArrayList<>();
        List<Method> myTestList = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyBefore.class)) {
                // 存储使用了@MyBefore注解的方法对象
                myBeforeList.add(method);
            } else if (method.isAnnotationPresent(MyTest.class)) {
                // 存储使用了@MyTest注解的方法对象
                myTestList.add(method);
            } else if (method.isAnnotationPresent(MyAfter.class)) {
                // 存储使用了@MyAfter注解的方法对象
                myAfterList.add(method);
            }
        }

        // 执行待测试方法：myTestList
        for (Method testMethod : myTestList) {
            // 先执行@MyBefore
            for (Method beforeMethod : myBeforeList) {
                beforeMethod.invoke(obj);
            }

            // 再执行@MyTest
            testMethod.invoke(obj);

            // 最后执行@MyAfter
            for (Method afterMethod : myAfterList) {
                afterMethod.invoke(obj);
            }
        }
    }
}