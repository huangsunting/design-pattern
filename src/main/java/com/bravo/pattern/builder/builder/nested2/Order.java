package com.bravo.pattern.builder.builder.nested2;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 嵌套Builder
 */
@Getter
@ToString
public class Order {

    private final String orderNumber;
    private final LocalDateTime orderTime;
    private final Address address;

    private Order(OrderBuilder builder) {
        this.orderNumber = builder.orderNumber;
        this.orderTime = builder.orderTime;
        this.address = builder.address;
    }

    public static OrderBuilder empty() {
        return new OrderBuilder();
    }

    public static class OrderBuilder {
        private String orderNumber;
        private LocalDateTime orderTime;
        private Address address;

        private OrderBuilder() {
        }

        public OrderBuilder withOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public OrderBuilder createdOn(LocalDateTime orderTime) {
            this.orderTime = orderTime;
            return this;
        }

        // 简化了这一步的复杂度
        public OrderBuilder shippedTo(String province, String city, String area) {
            this.address = new Address(province, city, area);
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
