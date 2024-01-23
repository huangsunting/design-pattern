package com.bravo.pattern.state.origin;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 售货机状态
 */
@AllArgsConstructor
public enum VendingStateEnum {
    SOLD_OUT(0, "售罄"),
    WAIT_TO_INSERT_COIN(1, "等待投币"),
    WAIT_TO_SELECT_GOODS(2, "等待选品"),
    WAIT_TO_DISPENSE_GOODS(3, "等待出货"),
    ;

    @Getter
    private final Integer code;
    @Getter
    private final String desc;
}