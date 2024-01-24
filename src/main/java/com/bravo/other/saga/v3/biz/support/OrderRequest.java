package com.bravo.other.saga.v3.biz.support;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderRequest {
    private Long prodId;
    private Integer buyNum;
}
