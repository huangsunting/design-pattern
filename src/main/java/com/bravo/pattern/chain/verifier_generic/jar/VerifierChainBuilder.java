package com.bravo.pattern.chain.verifier_generic.jar;

import java.util.ArrayList;
import java.util.List;

public class VerifierChainBuilder<I, O extends Result> {
    private final List<Verifier<I, O>> verifiers = new ArrayList<>();

    VerifierChainBuilder() {
    }

    public VerifierChainBuilder<I, O> add(final Verifier<I, O> verifier) {
        verifiers.add(verifier);
        return this;
    }

    public VerifyChainExecutor<I, O> build() {
        return new VerifyChainExecutor<>(this.verifiers);
    }
}