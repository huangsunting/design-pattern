package com.bravo.pattern.chain_of_responsibility.verifier.refactor1;


public class OrderConvertRefactorTest1 {

    public static void main(String[] args) {
        OrderConvertRequest request = new OrderConvertRequest(9527L, "123456", 1);
        OrderConvertService orderConvertService = new OrderConvertService();
        boolean convertResult = orderConvertService.convert(request);
        System.out.println(convertResult);
    }

}