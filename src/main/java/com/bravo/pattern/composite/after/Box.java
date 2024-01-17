package com.bravo.pattern.composite.after;

import lombok.Data;

import java.util.List;

@Data
public class Box implements BoxComponent {

    // 简化依赖：Box内部包含BoxComponent
    private List<BoxComponent> boxComponents;

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