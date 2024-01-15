package com.bravo.pattern.observer.springevent.listener;

import com.bravo.pattern.observer.springevent.event.Event;

public interface Listener<E extends Event> {

    /**
     * 事件发生时触发
     *
     * @param event 事件
     */
    void onApplicationEvent(E event);

    /**
     * 监听器是否匹配
     *
     * @param event 事件
     * @return 是否匹配
     */
    boolean supportsEventType(Event event);
}