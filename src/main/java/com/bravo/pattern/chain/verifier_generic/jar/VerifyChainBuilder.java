package com.bravo.pattern.chain.verifier_generic.jar;

import java.util.ArrayList;
import java.util.List;

public class VerifyChainBuilder<I, O extends Result> {
    private final List<Verifier<I, O>> verifiers = new ArrayList<>();

    VerifyChainBuilder() {
    }

    public VerifyChainBuilder<I, O> add(final Verifier<I, O> verifier) {
        verifiers.add(verifier);
        return this;
    }

    public VerifyChainExecutor<I, O> build() {
        return new VerifyChainExecutor<>(this.verifiers);
    }
}