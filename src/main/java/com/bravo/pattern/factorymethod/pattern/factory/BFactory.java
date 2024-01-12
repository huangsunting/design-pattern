package com.bravo.pattern.factorymethod.pattern.factory;

import com.bravo.pattern.factorymethod.pattern.product.AbstractProduct;
import com.bravo.pattern.factorymethod.pattern.product.BProduct;

public class BFactory extends AbstractFactory {

    @Override
    public AbstractProduct create() {
        return new BProduct();
    }
}