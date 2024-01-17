package com.bravo.pattern.chain.verifier.refactor3.support;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChannelEnum {

    TAO_BAO(1, "淘宝"),
    DOU_YIN(2, "抖音"),
    ;

    private final Integer code;
    private final String desc;
}