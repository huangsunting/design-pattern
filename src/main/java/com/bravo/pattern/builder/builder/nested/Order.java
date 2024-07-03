package com.bravo.pattern.builder.builder.nested;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.function.Function;

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
        this.address = builder.addressBuilder.build();
    }

    public static OrderBuilder empty() {
        return new OrderBuilder();
    }

    public static class OrderBuilder {
        private String orderNumber;
        private LocalDateTime orderTime;
        private Address.AddressBuilder addressBuilder = Address.builder();

        public OrderBuilder withOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public OrderBuilder createdOn(LocalDateTime orderTime) {
            this.orderTime = orderTime;
            return this;
        }

        public OrderBuilder shippedTo(Function<Address.AddressBuilder, Address.AddressBuilder> action) {
            // 也可以写成Consumer<Address.AddressBuilder> action
            // 这里用Function仅仅为了类型约束，强制客户程序返回Builder，禁止外部调用build()，因为我觉得挺丑的
            this.addressBuilder = action.apply(addressBuilder);
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
