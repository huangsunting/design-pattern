package com.bravo.pattern.guava;


import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusExample {

    public static void main(String[] args) {
        // 创建事件总线
        EventBus eventBus = new EventBus();

        // 注册订阅者
        EventSubscriber subscriber = new EventSubscriber();
        eventBus.register(subscriber);

        // 发布事件
        eventBus.post(new MessageEvent("Hello, Guava Event Bus!"));
    }

    // 定义事件类
    static class MessageEvent {
        private final String message;

        public MessageEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    // 定义订阅者类
    static class EventSubscriber {

        // 使用 @Subscribe 注解标识订阅方法
        @Subscribe
        public void handleMessageEvent(MessageEvent event) {
            System.out.println("Received message: " + event.getMessage());
        }
    }
}