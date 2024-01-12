package com.bravo.pattern.flyweight.impl2;


import com.bravo.pattern.flyweight.impl2.pojo.Student;
import com.bravo.pattern.flyweight.impl2.pojo.Teacher;

public class FlyweightTest {

    public static void main(String[] args) {
        new Student(1L, "学生1", "1号", "温州中学", "温州什么路", "努力学习");
        new Student(2L, "学生2", "2号", "温州中学", "温州什么路", "努力学习");
        new Student(3L, "学生3", "3号", "苍南中学", "苍南什么路", "好好学习");
        new Teacher(1L, "老师1", "1号", "苍南中学", "苍南什么路", "好好学习");
        new Teacher(2L, "老师2", "2号", "苍南中学", "苍南什么路", "好好学习");

        FlyweightFactory.printCache();
    }

}
