package com.bravo.pattern.simplefactory;


import com.bravo.pattern.simplefactory.product.AbstractProduct;

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
