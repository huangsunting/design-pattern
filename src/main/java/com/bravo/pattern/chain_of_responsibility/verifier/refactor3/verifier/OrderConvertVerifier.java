package com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifier;

import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Context;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Result;

public interface OrderConvertVerifier {

    Result verify(Context context);

}