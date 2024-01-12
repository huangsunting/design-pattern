package com.bravo.pattern.factorymethod.pattern;

import com.bravo.pattern.factorymethod.pattern.factory.AbstractFactory;
import com.bravo.pattern.factorymethod.pattern.product.AbstractProduct;

public class Client {

    private final AbstractFactory factory;

    public Client(AbstractFactory factory) {
        this.factory = factory;
    }

    public void method() {
        AbstractProduct product = this.factory.create();
    }

}
