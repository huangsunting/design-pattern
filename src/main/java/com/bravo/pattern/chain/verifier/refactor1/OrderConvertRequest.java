package com.bravo.pattern.chain.verifier.refactor1;

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

    public void validate() {
        if (this.getUserId() == null) {
            throw new IllegalArgumentException("用户未登录");
        }
        if (this.getOrderNo() == null || this.getOrderNo().trim().equals("")) {
            throw new IllegalArgumentException("订单号不能为空");
        }
        if (this.getChannel() == null) {
            throw new IllegalArgumentException("订单渠道不能为空");
        }
    }
}