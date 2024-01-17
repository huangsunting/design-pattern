package com.bravo.pattern.chain.verifier.refactor2.verifier;

import com.bravo.pattern.chain.verifier.refactor2.support.Context;
import com.bravo.pattern.chain.verifier.refactor2.support.Result;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component("orderNoConvertedVerifierRefactor2")
public class OrderNoConvertedVerifier implements OrderConvertVerifier {

    @Override
    public Result verify(Context context) {
        System.out.println("校验订单号");
        if (ThreadLocalRandom.current().nextInt(10) > 6) {
            return Result.failed("订单已被转换");
        }
        return Result.pass();
    }
}