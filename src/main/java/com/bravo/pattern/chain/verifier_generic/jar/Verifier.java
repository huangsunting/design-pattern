package com.bravo.pattern.chain.verifier_generic.jar;

public interface Verifier<I, O> {

    O verify(I request);

}
