package com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifier.douyin;

import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Context;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Result;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifier.OrderConvertVerifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component("douYinFirstConvertVerifierRefactor3")
public class DouYinFirstConvertVerifier implements OrderConvertVerifier {

    @Override
    public Result verify(Context context) {
        System.out.println("抖音独有校验");
        if (ThreadLocalRandom.current().nextInt(10) > 7) {
            return Result.failed("不符合抖音校验");
        }
        return Result.pass();
    }
}