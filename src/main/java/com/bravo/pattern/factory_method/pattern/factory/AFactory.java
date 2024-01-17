package com.bravo.pattern.factory_method.pattern.factory;

import com.bravo.pattern.factory_method.pattern.product.AProduct;
import com.bravo.pattern.factory_method.pattern.product.AbstractProduct;

public class AFactory extends AbstractFactory {

    @Override
    public AbstractProduct create() {
        return new AProduct();
    }
}