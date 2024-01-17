package com.bravo.pattern.chain.verifier_generic.biz.verifier;

import com.bravo.pattern.chain.verifier_generic.biz.support.BizRequest;
import com.bravo.pattern.chain.verifier_generic.jar.Result;
import com.bravo.pattern.chain.verifier_generic.jar.Verifier;
import org.springframework.stereotype.Component;

@Component
public class SecondVerifier implements Verifier<BizRequest, Result> {

    @Override
    public Result verify(BizRequest request) {
        System.out.println("SecondVerifier");
        return Result.fail("SecondVerifier fail");
    }

}