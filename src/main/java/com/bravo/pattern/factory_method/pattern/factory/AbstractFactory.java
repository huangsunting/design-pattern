package com.bravo.pattern.factory_method.pattern.factory;

import com.bravo.pattern.factory_method.pattern.product.AbstractProduct;

public abstract class AbstractFactory {
    public abstract AbstractProduct create();
}