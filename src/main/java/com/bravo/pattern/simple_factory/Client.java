package com.bravo.pattern.simple_factory;


import com.bravo.pattern.simple_factory.product.AbstractProduct;

public class Client {

    public void method(String type) {
        AbstractProduct product = SimpleFactory.create(type);
        System.out.println(product);
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.method("a");
    }
}
