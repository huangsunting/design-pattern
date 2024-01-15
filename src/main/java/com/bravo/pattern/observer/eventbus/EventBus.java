package com.bravo.pattern.observer.eventbus;

import com.bravo.pattern.observer.eventbus.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {
    private final Map<Class<?>, List<EventListener<?>>> listeners = new HashMap<>();

    /**
     * 注册监听器
     *
     * @param eventType 事件
     * @param listener  监听器，用于事件发生时回调
     * @param <T>       监听器类型
     */
    public <T> void register(Class<T> eventType, EventListener<?> listener) {
        List<EventListener<?>> listenersForEventType = listeners.computeIfAbsent(eventType, k -> new ArrayList<>());
        listenersForEventType.add(listener);
    }

    /**
     * 移除监听器
     *
     * @param eventType 事件
     * @param listener  监听器，用于事件发生时回调
     * @param <T>       监听器类型
     */
    public <T> void unregister(Class<T> eventType, EventListener<?> listener) {
        List<EventListener<?>> listenersForEventType = listeners.get(eventType);
        if (listenersForEventType != null) {
            listenersForEventType.remove(listener);
        }
    }

    /**
     * 发布事件
     *
     * @param event 事件
     * @param <T>   事件类型
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> void post(T event) {
        List<EventListener<?>> listenersForEventType = listeners.get(event.getClass());
        if (listenersForEventType != null) {
            for (EventListener listener : listenersForEventType) {
                listener.onEvent(event);
            }
        }
    }
}
