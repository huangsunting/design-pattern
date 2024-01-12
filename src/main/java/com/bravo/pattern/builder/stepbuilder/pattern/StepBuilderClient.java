package com.bravo.pattern.builder.stepbuilder.pattern;

public class StepBuilderClient {

    public static void main(String[] args) {
        Product product = Product.builder()
                .step1("step1")
                .step2("step2")
                .step3("step3")
                .build();
        System.out.println(product);
    }
}
