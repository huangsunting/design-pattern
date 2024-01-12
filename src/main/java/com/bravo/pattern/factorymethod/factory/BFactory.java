package com.bravo.pattern.factorymethod.factory;

import com.bravo.pattern.factorymethod.product.AbstractProduct;
import com.bravo.pattern.factorymethod.product.BProduct;

public class BFactory extends AbstractFactory {

    @Override
    public AbstractProduct create() {
        return new BProduct();
    }
}