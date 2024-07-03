package com.bravo.advanced.annotation.junit.use;

import com.bravo.advanced.annotation.junit.define.After;
import com.bravo.advanced.annotation.junit.define.Before;
import com.bravo.advanced.annotation.junit.define.Test;
import com.bravo.advanced.annotation.junit.parse.JunitFrameWork;

/**
 * 和我们平时使用Junit一样
 * 但是测试的入口不在这，因为@Test没有被识别为可测试的方法
 *
 * @see JunitFrameWork
 */
public class UserTest {
    @Before
    public void init() {
        System.out.println("初始化...");
    }

    @After
    public void destroy() {
        System.out.println("销毁...");
    }

    @Test
    public void testSave() {
        System.out.println("save...");
    }

    @Test
    public void testDelete() {
        System.out.println("delete...");
    }
}