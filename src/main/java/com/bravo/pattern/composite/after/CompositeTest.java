package com.bravo.pattern.composite.after;

public class CompositeTest {

    public static void main(String[] args) {
        Box bigBox = constructBox();

        double totalSum = bigBox.calculatePrice();

        System.out.println(totalSum);
    }

    private static Box constructBox() {
        Box box1 = new Box();
        box1.add(new Product("iphone", 5000, 0));
        box1.add(new Product("篮球鞋", 4000, 0));

        Box box2 = new Box();
        box2.add(new Product("铅笔", 400, 0));
        box2.add(new Product("橡皮", 300, 0));

        Box bigBox = new Box();
        bigBox.add(box1);
        bigBox.add(box2);
        bigBox.add(new Product("笔记本电脑", 10000, 0));
        bigBox.add(new Product("鼠标垫", 300, 1));
        return bigBox;
    }
}