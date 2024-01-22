package com.bravo.pattern.visitor.double_dispatch;

import com.bravo.pattern.visitor.double_dispatch.inheritance.Father;
import com.bravo.pattern.visitor.double_dispatch.inheritance.Son;
import com.bravo.pattern.visitor.double_dispatch.visitor.PrinterA;

/**
 * Father和Son代表对象结构
 * Printer则是Visitor
 */
public class DoubleDispatchTest {

    public static void main(String[] args) {
        Father man = new Son();

        // 动态分派
        man.say();          // 方法重写（Son实例）：say in Son

        // 静态分派
        PrinterA printerA = new PrinterA();
        printerA.print(man); // 方法重载（Father类型）：print father in PrinterA

        // 双重分派
        man.accept(printerA);// 打印什么？

        // PrinterB printerB = new PrinterB();
        // man.accept(printerB);
    }
}