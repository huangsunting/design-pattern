package com.bravo.pattern.chain.verifier_generic.jar;

import java.util.List;

public class VerifyChainExecutor<I, O extends Result> {

    private final List<Verifier<I, O>> verifiers;

    VerifyChainExecutor(List<Verifier<I, O>> verifiers) {
        this.verifiers = verifiers;
    }

    public O execute(I request) {
        O result = null;
        for (Verifier<I, O> verifier : verifiers) {
            result = verifier.verify(request);
            if (!result.isPass()) {
                // 提前结束
                return result;
            }
        }
        return result;
    }

    public static <I, O extends Result> VerifierChainBuilder<I, O> builder() {
        return new VerifierChainBuilder<>();
    }
}