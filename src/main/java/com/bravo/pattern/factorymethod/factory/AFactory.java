package com.bravo.pattern.factorymethod.factory;

import com.bravo.pattern.factorymethod.product.AProduct;
import com.bravo.pattern.factorymethod.product.AbstractProduct;

public class AFactory extends AbstractFactory {

    @Override
    public AbstractProduct create() {
        return new AProduct();
    }
}