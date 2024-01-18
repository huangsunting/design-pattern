package com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifychain;


import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Context;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.OrderConvertRequest;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Result;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifier.OrderConvertVerifier;

import java.util.List;

/**
 * 可以看一下这个代码的提交记录，我把淘宝和抖音相同的代码提取到了这里
 */
public abstract class AbstractOrderConvertVerifyChain implements OrderConvertVerifyChain {

    @Override
    public Result verify(OrderConvertRequest request) {
        Context context = new Context();
        context.setRequest(request);
        for (OrderConvertVerifier verifier : this.getVerifiers()) {
            Result result = verifier.verify(context);
            if (!result.isPass()) {
                return result;
            }
        }
        return Result.pass();
    }

    /**
     * 延迟给子类实现
     */
    protected abstract List<OrderConvertVerifier> getVerifiers();

}
