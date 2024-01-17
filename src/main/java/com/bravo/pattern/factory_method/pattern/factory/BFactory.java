package com.bravo.pattern.factory_method.pattern.factory;

import com.bravo.pattern.factory_method.pattern.product.AbstractProduct;
import com.bravo.pattern.factory_method.pattern.product.BProduct;

public class BFactory extends AbstractFactory {

    @Override
    public AbstractProduct create() {
        return new BProduct();
    }
}