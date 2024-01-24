package com.bravo.other.saga.v2.jar;

public interface Step<C> {
    void execute(C context);

    void rollback(C context);
}