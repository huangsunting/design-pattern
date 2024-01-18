package com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifier.common;

import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Context;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Result;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifier.OrderConvertVerifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component("orderNoConvertedVerifierRefactor3")
public class OrderNoConvertedVerifier implements OrderConvertVerifier {

    @Override
    public Result verify(Context context) {
        System.out.println("校验订单号");
        if (ThreadLocalRandom.current().nextInt(10) > 7) {
            return Result.failed("订单已被转换");
        }
        return Result.pass();
    }
}