package com.bravo.pattern.prototype.classicalimpl;

public class PrototypeClient {

    public static void main(String[] args) {
        // 假设这是已有的一个对象
        Circle circle = new Circle(5, 0, 0);
        // 出于一些原因，你需要拷贝这个对象
        Circle cloneCircle = (Circle) circle.copy();

        System.out.println("原对象：" + circle);
        System.out.println("克隆对象：" + cloneCircle);
        System.out.println("地址是否相等：" + (circle == cloneCircle));
    }
}