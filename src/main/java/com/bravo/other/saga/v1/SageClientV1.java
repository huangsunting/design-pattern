package com.bravo.other.saga.v1;

import com.bravo.other.saga.v1.step.Step1;
import com.bravo.other.saga.v1.step.Step2;
import com.bravo.other.saga.v1.step.Step3;

public class SageClientV1 {
    public static void main(String[] args) {
        Context context = new Context();

        // 创建 Saga
        Saga saga = new Saga();
        saga.addStep(new Step1());
        saga.addStep(new Step2());
        saga.addStep(new Step3());

        // 模拟执行
        try {
            saga.execute(context);
            // 如果执行成功，继续后续操作
        } catch (Exception e) {
            // 执行失败，回滚到之前的状态
            System.err.println("Saga execution failed");
        }
    }
}