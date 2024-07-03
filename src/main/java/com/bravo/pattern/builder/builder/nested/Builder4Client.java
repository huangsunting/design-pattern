package com.bravo.pattern.builder.builder.nested;

import java.time.LocalDateTime;

/**
 * 嵌套的Builder模式
 */
public class Builder4Client {

    public static void main(String[] args) {
        // 代码可读性
        Order order = Order.empty()
                .withOrderNumber("123456789")
                .createdOn(LocalDateTime.now())
                .shippedTo(b -> b
                        .province("广东省")
                        .city("广州市")
                        .area("海珠区")
                )
                .build();
        System.out.println(order);
    }

}
