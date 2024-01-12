package com.bravo.pattern.factorymethod;

import com.bravo.pattern.factorymethod.factory.AbstractFactory;
import com.bravo.pattern.factorymethod.product.AbstractProduct;

public class Client {

    private final AbstractFactory factory;

    public Client(AbstractFactory factory) {
        this.factory = factory;
    }

    public void method() {
        AbstractProduct product = this.factory.create();
    }

}
