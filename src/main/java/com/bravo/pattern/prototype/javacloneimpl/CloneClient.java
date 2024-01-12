package com.bravo.pattern.prototype.javacloneimpl;


public class CloneClient {
    public static void main(String[] args) {
        Circle circle = new Circle(5, 0, 0);
        Circle cloneCircle = circle.copy();
        System.out.println("原对象：" + circle);
        System.out.println("克隆对象：" + cloneCircle);
        System.out.println("地址是否相等：" + (circle == cloneCircle));
    }
}
