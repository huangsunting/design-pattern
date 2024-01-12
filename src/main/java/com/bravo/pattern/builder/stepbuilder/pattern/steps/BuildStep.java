package com.bravo.pattern.builder.stepbuilder.pattern.steps;


import com.bravo.pattern.builder.stepbuilder.pattern.Product;

public interface BuildStep {
    // 最后一步返回Product
    Product build();
}