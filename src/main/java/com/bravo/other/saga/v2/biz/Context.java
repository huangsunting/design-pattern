package com.bravo.other.saga.v2.biz;

import lombok.Data;

@Data
public class Context {
	// 请求参数
    private Long requestProdId;
    private Integer requestBuyNum;

    // 过程变量
    private String contextOrderId;
    private Integer contextSkuDeduceNum;
    private Long contextCouponId;
}