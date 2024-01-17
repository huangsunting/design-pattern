package com.bravo.pattern.chain.verifier.refactor3.verifier.taobao;

import com.bravo.pattern.chain.verifier.refactor3.support.Context;
import com.bravo.pattern.chain.verifier.refactor3.support.Result;
import com.bravo.pattern.chain.verifier.refactor3.verifier.OrderConvertVerifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component("taoBaoFirstConvertVerifierRefactor3")
public class TaoBaoFirstConvertVerifier implements OrderConvertVerifier {

    @Override
    public Result verify(Context context) {
        System.out.println("淘宝独有校验");
        if (ThreadLocalRandom.current().nextInt(10) > 7) {
            return Result.failed("不符合淘宝校验");
        }
        return Result.pass();
    }
}