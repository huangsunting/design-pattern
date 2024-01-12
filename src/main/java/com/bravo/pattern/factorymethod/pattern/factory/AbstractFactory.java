package com.bravo.pattern.factorymethod.pattern.factory;

import com.bravo.pattern.factorymethod.pattern.product.AbstractProduct;

public abstract class AbstractFactory {
    public abstract AbstractProduct create();
}