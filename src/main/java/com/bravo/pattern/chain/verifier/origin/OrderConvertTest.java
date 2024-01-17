package com.bravo.pattern.chain.verifier.origin;

public class OrderConvertTest {

    public static void main(String[] args) {
        OrderConvertRequest request = new OrderConvertRequest(9527L, "123456", 1);
        OrderConvertService orderConvertService = new OrderConvertService();
        boolean convertResult = orderConvertService.convert(request);
        System.out.println(convertResult);
    }

}