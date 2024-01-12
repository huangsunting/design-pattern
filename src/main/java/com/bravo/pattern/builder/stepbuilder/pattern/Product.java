package com.bravo.pattern.builder.stepbuilder.pattern;

import com.bravo.pattern.builder.stepbuilder.pattern.steps.BuildStep;
import com.bravo.pattern.builder.stepbuilder.pattern.steps.Step1;
import com.bravo.pattern.builder.stepbuilder.pattern.steps.Step2;
import com.bravo.pattern.builder.stepbuilder.pattern.steps.Step3;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private String part1;
    private String part2;
    private String part3;

    private Product() {
    }

    // 初始入口：构建从这里开始
    public static Step1 builder() {
        return new ProductBuilder();
    }

    // 实现所有Step
    private static class ProductBuilder implements Step1, Step2, Step3, BuildStep {
        private final Product product;

        private ProductBuilder() {
            this.product = new Product();
        }

        // 4个@Override就是对4个步骤的实现，由返回值串联这个步骤，形成顺序
        @Override
        public Step2 step1(String part1) {
            product.part1 = part1;
            return this;
        }

        @Override
        public Step3 step2(String part2) {
            product.part2 = part2;
            return this;
        }

        @Override
        public BuildStep step3(String part3) {
            product.part3 = part3;
            return this;
        }

        @Override
        public Product build() {
            return product;
        }
    }
}