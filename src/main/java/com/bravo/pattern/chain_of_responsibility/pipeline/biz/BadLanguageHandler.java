package com.bravo.pattern.chain_of_responsibility.pipeline.biz;

import com.bravo.pattern.chain_of_responsibility.pipeline.jar.Handler;

// 敏感词过滤
public class BadLanguageHandler implements Handler<String, String> {
    @Override
    public String process(String input) {
        return input.replace("我日", "**");
    }
}