package com.bravo.pattern.factory_method.pattern;

import com.bravo.pattern.factory_method.pattern.factory.AbstractFactory;
import com.bravo.pattern.factory_method.pattern.product.AbstractProduct;

public class Client {

    private final AbstractFactory factory;

    public Client(AbstractFactory factory) {
        this.factory = factory;
    }

    public void method() {
        AbstractProduct product = this.factory.create();
    }

}
