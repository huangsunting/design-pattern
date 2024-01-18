package com.bravo.pattern.chain_of_responsibility.verifier.refactor2.verifier;

import com.bravo.pattern.chain_of_responsibility.verifier.refactor2.support.Context;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor2.support.Result;

public interface OrderConvertVerifier {

    Result verify(Context context);

}