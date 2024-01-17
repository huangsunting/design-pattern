package com.bravo.pattern.composite.after;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product implements BoxComponent { // 实现BoxComponent

    private final String title;
    private final double price;
    private final double tax;

    @Override
    public double calculatePrice() {
        // 商品价格+关税
        return price + tax;
    }
}