package com.bravo.pattern.chain.verifier.refactor3.verifychain;

import com.bravo.pattern.chain.verifier.refactor3.support.OrderConvertRequest;
import com.bravo.pattern.chain.verifier.refactor3.support.Result;

// 将VerifyChain抽象为接口
public interface OrderConvertVerifyChain {

    // 用于渠道匹配
    boolean match(Integer channel);

    // 订单转换校验
    Result verify(OrderConvertRequest request);

}