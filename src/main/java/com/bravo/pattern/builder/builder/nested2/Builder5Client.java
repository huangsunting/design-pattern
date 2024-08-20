package com.bravo.pattern.builder.builder.nested2;

import java.time.LocalDateTime;

/**
 * 嵌套的Builder模式（简易版）
 * nested1的代码会比较复杂，如果仅仅是为了可读性，可以采用nested2的做法。
 * nested2的缺点是，后期如果Address字段变更，会影响shippedTo()的方法签名。
 * 但假定shippedTo()方法签名很稳定，那么使用nested2无疑更简单。
 */
public class Builder5Client {

    public static void main(String[] args) {
        // 代码可读性好，实现也简单
        Order order = Order.empty()
                .withOrderNumber("123456789")
                .createdOn(LocalDateTime.now())
                .shippedTo("广东省", "广州市", "海珠区")
                .build();
        System.out.println(order);
    }

}
