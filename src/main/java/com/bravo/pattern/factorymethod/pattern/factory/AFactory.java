package com.bravo.pattern.factorymethod.pattern.factory;

import com.bravo.pattern.factorymethod.pattern.product.AProduct;
import com.bravo.pattern.factorymethod.pattern.product.AbstractProduct;

public class AFactory extends AbstractFactory {

    @Override
    public AbstractProduct create() {
        return new AProduct();
    }
}