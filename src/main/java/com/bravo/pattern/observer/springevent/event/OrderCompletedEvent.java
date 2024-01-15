package com.bravo.pattern.observer.springevent.event;

/**
 * 下单事件
 */
public class OrderCompletedEvent extends Event {
    public OrderCompletedEvent(Long source) {
        super(source);
    }
}