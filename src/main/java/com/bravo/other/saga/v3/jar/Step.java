package com.bravo.other.saga.v3.jar;

public interface Step<I, O, C> {
    void process(Pipeline<I, O, C> pipeline);

    void rollback(Pipeline<I, O, C> pipeline);
}