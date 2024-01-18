package com.bravo.pattern.chain_of_responsibility.verifier_generic.jar;

public interface Verifier<I, O> {

    O verify(I request);

}
