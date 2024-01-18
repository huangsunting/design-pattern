package com.bravo.pattern.composite.after;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合节点
 */
public class Box implements BoxComponent {

    // 简化依赖：Box内部包含BoxComponent
    private final List<BoxComponent> boxComponents = new ArrayList<>();

    // 添加子组件
    public void add(BoxComponent boxComponent){
        this.boxComponents.add(boxComponent);
    }

    @Override
    public double calculatePrice() {

        double totalSum = 0;

        for (BoxComponent boxComponent : boxComponents) {
            // 递归计算组件的价格
            totalSum += boxComponent.calculatePrice();
        }

        return totalSum;
    }
}