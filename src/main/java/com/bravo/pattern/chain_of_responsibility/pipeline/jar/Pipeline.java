package com.bravo.pattern.chain_of_responsibility.pipeline.jar;

public class Pipeline<I, O> {

    private final Handler<I, O> currentHandler;

    public Pipeline(Handler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }

    // 把下一个步骤追加到当前步骤之后
    public <K> Pipeline<I, K> addHandler(Handler<O, K> nextHandler) {
        return new Pipeline<>(input -> nextHandler.process(currentHandler.process(input)));
    }

    public O execute(I input) {
        return currentHandler.process(input);
    }
}