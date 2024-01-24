package com.bravo.other.saga.v2.jar;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Saga<C> {
    private final List<Step<C>> steps = new ArrayList<>();

    public void addStep(Step<C> step) {
        steps.add(step);
    }

    public void execute(C context) {
        for (Step<C> step : steps) {
            try {
                step.execute(context);
            } catch (HaltException he) {
                rollback(context);
                log.warn("Sage HaltException, context:{}", context, he);
                throw he;
            } catch (Exception e) {
                rollback(context);
                log.error("Sage Exception, context:{}", context, e);
                throw e;
            }
        }
    }

    private void rollback(C context) {
        for (int i = steps.size() - 1; i >= 0; i--) {
            steps.get(i).rollback(context);
        }
    }
}