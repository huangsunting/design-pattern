package com.bravo.pattern.chain.pipeline.biz;

import com.bravo.pattern.chain.pipeline.jar.Handler;

// 去除首尾空格
public class SpaceHandler implements Handler<String, String> {
    @Override
    public String process(String input) {
        return input.trim();
    }
}