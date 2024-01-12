package com.bravo.pattern.builder.builder.impl3;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {
    private final String part1;
    private final String part2;
    private final String part3;

    // 和impl1的区别是：这里接收builder，关系更紧密了
    private Product(ProductBuilder builder) {
        this.part1 = builder.part1;
        this.part2 = builder.part2;
        this.part3 = builder.part3;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private String part1;
        private String part2;
        private String part3;

        private ProductBuilder() {
        }

        public ProductBuilder step1(String part1) {
            this.part1 = part1;
            return this;
        }

        public ProductBuilder step2(String part2) {
            this.part2 = part2;
            return this;
        }

        public ProductBuilder step3(String part3) {
            this.part3 = part3;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}