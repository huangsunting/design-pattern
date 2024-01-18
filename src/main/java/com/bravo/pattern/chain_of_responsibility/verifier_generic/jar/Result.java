package com.bravo.pattern.chain_of_responsibility.verifier_generic.jar;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

    private boolean isPass;

    private String errMsg;

    private final static Result PASS = new Result(true, null);

    public static Result pass() {
        return PASS;
    }

    public static Result fail(String errMsg) {
        return new Result(false, errMsg);
    }
}