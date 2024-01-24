package com.bravo.other.saga.v3.biz.support;

import lombok.Data;
import lombok.ToString;

@Data
public class OrderContext {
    private String orderId;
    private Integer skuDeduceNum;
    private Long couponId;
}
