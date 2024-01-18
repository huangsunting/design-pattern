package com.bravo.pattern.chain_of_responsibility.pipeline.jar;

/**
 * 管道操作
 *
 * @param <I> Input
 * @param <O> Output
 */
public interface Handler<I, O> {
    // 每个步骤的处理逻辑：给定输入，返回结果
    O process(I input);
}