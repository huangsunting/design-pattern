package com.bravo.pattern.chain.verifier_generic.biz.verifier;

import com.bravo.pattern.chain.verifier_generic.biz.support.BizRequest;
import com.bravo.pattern.chain.verifier_generic.biz.support.BizResult;
import com.bravo.pattern.chain.verifier_generic.jar.Verifier;
import org.springframework.stereotype.Component;

@Component
public class SecondVerifier implements Verifier<BizRequest, BizResult> {

    @Override
    public BizResult verify(BizRequest request) {
        System.out.println("SecondVerifier");
        return BizResult.fail("SecondVerifier校验失败");
    }

}