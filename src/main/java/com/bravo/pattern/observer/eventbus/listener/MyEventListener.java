package com.bravo.pattern.observer.eventbus.listener;

import com.bravo.pattern.observer.eventbus.event.MyEvent;

public class MyEventListener implements EventListener<MyEvent> {
    @Override
    public void onEvent(MyEvent event) {
        System.out.println("Processing event: " + event.getMessage());
    }
}
