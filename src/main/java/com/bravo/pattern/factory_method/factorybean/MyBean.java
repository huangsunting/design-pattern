package com.bravo.pattern.factory_method.factorybean;

public class MyBean {

    private final String message;

    public MyBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
