package com.bravo.pattern.simplefactory;


import com.bravo.pattern.simplefactory.product.AProduct;
import com.bravo.pattern.simplefactory.product.AbstractProduct;
import com.bravo.pattern.simplefactory.product.BProduct;

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
