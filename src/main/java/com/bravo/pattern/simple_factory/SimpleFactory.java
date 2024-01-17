package com.bravo.pattern.simple_factory;


import com.bravo.pattern.simple_factory.product.AProduct;
import com.bravo.pattern.simple_factory.product.AbstractProduct;
import com.bravo.pattern.simple_factory.product.BProduct;

public class SimpleFactory {

    public static AbstractProduct create(String type) {
        if ("a".equals(type)) {
            return new AProduct();
        } else if ("b".equals(type)) {
            return new BProduct();
        } else {
            throw new RuntimeException("产品类型错误");
        }
    }

}
