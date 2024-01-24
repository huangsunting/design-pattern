package com.bravo.other.saga.v1.step;

import com.bravo.other.saga.v1.Context;

import java.util.concurrent.ThreadLocalRandom;

// 步骤3
public class Step3 implements Step {
    @Override
    public void execute(Context context) {
        if (ThreadLocalRandom.current().nextBoolean()) {
            System.out.println("Step 3 error!!!!");
            throw new RuntimeException("执行错误");
        }
        System.out.println("Step 3 executed");
    }

    @Override
    public void rollback(Context context) {
        System.out.println("Step 3 rolled back");
    }
}