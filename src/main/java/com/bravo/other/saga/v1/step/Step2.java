package com.bravo.other.saga.v1.step;

import com.bravo.other.saga.v1.Context;

// 步骤2
public class Step2 implements Step {
    @Override
    public void execute(Context context) {
        System.out.println("Step 2 executed");
    }

    @Override
    public void rollback(Context context) {
        System.out.println("Step 2 rolled back");
    }
}