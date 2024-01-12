package com.bravo.pattern.builder.builder.impl3;


public class Builder3Client {

    public static void main(String[] args) {
        Product product = Product.builder()
                .step1("第一步")
                .step2("第二步")
                .step3("第三步")
                .build();
        System.out.println(product);
    }
}
