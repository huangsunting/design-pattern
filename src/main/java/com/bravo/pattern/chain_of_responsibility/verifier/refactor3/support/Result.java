package com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support;

import lombok.Data;

@Data
public class Result {

    private boolean isPass;

    private String errMsg;

    public static Result pass() {
        return new Result(true);
    }

    public static Result failed(String errMsg) {
        return new Result(false, errMsg);
    }

    public Result(boolean isPass) {
        this.isPass = isPass;
    }

    public Result(boolean isPass, String errMsg) {
        this.isPass = isPass;
        this.errMsg = errMsg;
    }
}