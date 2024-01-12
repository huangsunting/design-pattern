package com.bravo.pattern.factorymethod.factory;

import com.bravo.pattern.factorymethod.product.AbstractProduct;

public abstract class AbstractFactory {
    public abstract AbstractProduct create();
}