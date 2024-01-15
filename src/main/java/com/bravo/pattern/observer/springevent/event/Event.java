package com.bravo.pattern.observer.springevent.event;

import lombok.Getter;

@Getter
public class Event {

    private final Object source;

    public Event(Object source) {
        this.source = source;
    }
}