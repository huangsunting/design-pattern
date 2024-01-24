package com.bravo.other.saga.v3.jar;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Saga<I, O, C> {

    private final List<Step<I, O, C>> steps;

    private Saga(List<Step<I, O, C>> steps) {
        this.steps = steps;
    }

    public static <I, O, C> SagaBuilder<I, O, C> builder() {
        return new SagaBuilder<>();
    }

    public O execute(Pipeline<I, O, C> pipeline) {
        try {
            executeStages(pipeline);
        } catch (Exception e) {
            executeRollbackStages(pipeline);
            throw e;
        }
        return pipeline.getResponse();
    }

    private void executeStages(Pipeline<I, O, C> pipeline) {
        if (steps.size() > 0) {
            for (Step<I, O, C> step : steps) {
                Long start = System.currentTimeMillis();
                step.process(pipeline);
                Long end = System.currentTimeMillis();
                log.info("step:{}执行结束, 耗时:{}, request:{}", step.getClass().getName(), end - start, pipeline.getRequest());
            }
        }
    }

    private void executeRollbackStages(Pipeline<I, O, C> pipeline) {
        if (steps.size() > 0) {
            for (Step<I, O, C> step : steps) {
                step.rollback(pipeline);
            }
        }
    }

    /***** Saga Builder *****/
    public static class SagaBuilder<I, O, C> {
        private final List<Step<I, O, C>> stages = new ArrayList<>();

        public SagaBuilder<I, O, C> addStage(Step<I, O, C> stage) {
            stages.add(stage);
            return this;
        }

        public Saga<I, O, C> build() {
            return new Saga<>(stages);
        }
    }
}