package com.bravo.pattern.chain_of_responsibility.verifier.origin;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderConvertRequest {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 渠道：淘宝、抖音、快手
     */
    private Integer channel;
}