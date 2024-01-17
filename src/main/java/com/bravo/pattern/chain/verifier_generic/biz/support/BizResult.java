package com.bravo.pattern.chain.verifier_generic.biz.support;

import com.bravo.pattern.chain.verifier_generic.jar.Result;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BizResult implements Result {

    private boolean isPass;

    private String errMsg;

    private final static BizResult PASS;

    static {
        PASS = new BizResult(true, null);
    }

    public static BizResult pass() {
        return PASS;
    }

    @Override
    public boolean isPass() {
        return isPass;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }
}