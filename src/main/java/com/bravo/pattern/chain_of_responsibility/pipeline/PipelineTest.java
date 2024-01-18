package com.bravo.pattern.chain_of_responsibility.pipeline;

import com.bravo.pattern.chain_of_responsibility.pipeline.biz.BadLanguageHandler;
import com.bravo.pattern.chain_of_responsibility.pipeline.biz.MessageHandler;
import com.bravo.pattern.chain_of_responsibility.pipeline.biz.SpaceHandler;
import com.bravo.pattern.chain_of_responsibility.pipeline.biz.UserMessage;
import com.bravo.pattern.chain_of_responsibility.pipeline.jar.Pipeline;

public class PipelineTest {
    public static void main(String[] args) {
        Pipeline<String, UserMessage> steps = new Pipeline<>(new SpaceHandler())
                .addHandler(new BadLanguageHandler()) // 接管子，一节连着一节
                .addHandler(new MessageHandler());
        UserMessage userMessage = steps.execute("你是我日日夜夜思念的人");
        System.out.println(userMessage);
    }
}