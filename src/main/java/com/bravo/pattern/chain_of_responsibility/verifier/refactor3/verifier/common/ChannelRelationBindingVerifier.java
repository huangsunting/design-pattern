package com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifier.common;

import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Context;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Result;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifier.OrderConvertVerifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component("channelRelationBindingVerifierRefactor3")
public class ChannelRelationBindingVerifier implements OrderConvertVerifier {

    @Override
    public Result verify(Context context) {
        System.out.println("校验渠道账号");
        if (ThreadLocalRandom.current().nextInt(10) > 7) {
            return Result.failed("账号已被绑定");
        }
        return Result.pass();
    }
}