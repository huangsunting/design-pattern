package com.bravo.pattern.chain_of_responsibility.verifier.refactor2.verifier;

import com.bravo.pattern.chain_of_responsibility.verifier.refactor2.support.Context;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor2.support.Result;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component("channelRelationBindingVerifierRefactor2")
public class ChannelRelationBindingVerifier implements OrderConvertVerifier {

    @Override
    public Result verify(Context context) {
        System.out.println("校验渠道账号");
        if (ThreadLocalRandom.current().nextInt(10) > 6) {
            return Result.failed("账号已被绑定");
        }
        return Result.pass();
    }
}