package com.bravo.pattern.chain.pipeline.biz;

import com.bravo.pattern.chain.pipeline.jar.Handler;

import java.util.Date;

// 附加用户信息和发送时间
public class MessageHandler implements Handler<String, UserMessage> {
    @Override
    public UserMessage process(String input) {
        return new UserMessage("bravo1988", input, new Date());
    }
}