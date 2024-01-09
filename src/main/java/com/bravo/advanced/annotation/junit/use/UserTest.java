package com.bravo.advanced.annotation.junit.use;

import com.bravo.advanced.annotation.junit.define.MyAfter;
import com.bravo.advanced.annotation.junit.define.MyBefore;
import com.bravo.advanced.annotation.junit.define.MyTest;

/**
 * 和我们平时使用Junit一样
 * 但是测试的入口不在这，因为@MyTest没有被识别为可测试的方法
 *
 * @see com.bravo.advanced.annotation.junit.parse.MyJunitFrameWork
 */
public class UserTest {
    @MyBefore
    public void init() {
        System.out.println("初始化...");
    }

    @MyAfter
    public void destroy() {
        System.out.println("销毁...");
    }

    @MyTest
    public void testSave() {
        System.out.println("save...");
    }

    @MyTest
    public void testDelete() {
        System.out.println("delete...");
    }
}