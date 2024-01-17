package com.bravo.pattern.composite.before;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoxTest {

    public static void main(String[] args) {
        Box bigBox = constructBox();

        double totalSum = calculatePrice(bigBox);
        
        System.out.println(totalSum);
    }

    public static double calculatePrice(Box box) {
        double totalSum = 0;

        for (Product product : box.getProducts()) {
            // 累加当前box中【商品】的price
            totalSum += product.getPrice();
        }

        for (Box subBox : box.getBoxes()) {
            // 累加当前box中【小包裹】的price（递归！！！）
            totalSum += calculatePrice(subBox);
        }

        return totalSum;
    }

    private static Box constructBox() {
        Box box1 = new Box();
        box1.setBoxes(Collections.emptyList());
        box1.setProducts(Arrays.asList(new Product("iphone", 5000), new Product("篮球鞋", 4000)));

        Box box2 = new Box();
        box2.setBoxes(Collections.emptyList());
        box2.setProducts(Arrays.asList(new Product("铅笔", 400), new Product("橡皮", 300)));

        List<Box> subBoxes = Arrays.asList(box1, box2);

        Box bigBox = new Box();
        bigBox.setBoxes(subBoxes);
        bigBox.setProducts(Arrays.asList(new Product("笔记本电脑", 10000), new Product("鼠标垫", 300)));
        return bigBox;
    }
}