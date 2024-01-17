package com.bravo.pattern.composite.after;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeTest {

    public static void main(String[] args) {
        Box bigBox = constructBox();

        double totalSum = bigBox.calculatePrice();

        System.out.println(totalSum);
    }

    private static Box constructBox() {
        Box box1 = new Box();
        box1.setBoxComponents(Arrays.asList(new Product("iphone", 5000, 0), new Product("篮球鞋", 4000, 0)));

        Box box2 = new Box();
        box2.setBoxComponents(Arrays.asList(new Product("铅笔", 400, 0), new Product("橡皮", 300, 0)));

        List<BoxComponent> subBoxes = new ArrayList<>();
        subBoxes.add(box1);
        subBoxes.add(box2);

        Box bigBox = new Box();
        bigBox.setBoxComponents(subBoxes);
        bigBox.getBoxComponents().add(new Product("笔记本电脑", 10000, 0));
        bigBox.getBoxComponents().add(new Product("鼠标垫", 300, 1));
        return bigBox;
    }
}