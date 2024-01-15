package com.bravo.pattern.observer.eventbus;

import com.bravo.pattern.observer.eventbus.event.MyEvent;
import com.bravo.pattern.observer.eventbus.listener.MyEventListener;

public class EventBusClient {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        // 注册监听器
        eventBus.register(MyEvent.class, new MyEventListener());

        // 发布事件
        MyEvent myEvent = new MyEvent("Hello, EventBus!");
        eventBus.post(myEvent);
    }
}