package com.bravo.other.saga.v1;

import com.bravo.other.saga.v1.step.Step;

import java.util.ArrayList;
import java.util.List;

// Saga 类，负责协调执行和回滚
public class Saga {
    private final List<Step> steps = new ArrayList<>();

    public void addStep(Step step) {
        steps.add(step);
    }

    public void execute(Context context) {
        for (Step step : steps) {
            try {
                step.execute(context);
            } catch (Exception e) {
                // 回滚
                rollback(context);
                throw e;
            }
        }
    }

    private void rollback(Context context) {
        for (int i = steps.size() - 1; i >= 0; i--) {
            steps.get(i).rollback(context);
        }
    }
}