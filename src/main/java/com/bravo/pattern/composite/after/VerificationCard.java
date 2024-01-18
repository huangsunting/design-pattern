package com.bravo.pattern.composite.after;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 叶子节点
 */
@Getter
@AllArgsConstructor
public class VerificationCard implements BoxComponent { // 实现BoxComponent

    private final String title;
    private final double price;

    @Override
    public double calculatePrice() {
        // 核销券总价值
        return price;
    }
}