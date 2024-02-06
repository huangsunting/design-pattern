package com.bravo.pattern.observer.springevent;

import com.bravo.pattern.observer.springevent.event.Event;
import com.bravo.pattern.observer.springevent.listener.Listener;
import org.springframework.lang.Nullable;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

public class ApplicationContext {

    private final Set<Listener<?>> listeners = new LinkedHashSet<>();

    // 线程池：用于支持异步事件
    @Nullable
    private Executor taskExecutor;

    /**
     * 注册监听器
     *
     * @param listener 监听器
     */
    public void registerListener(Listener<?> listener) {
        listeners.add(listener);
    }

    /**
     * 发布事件
     *
     * @param event 事件
     */
    public void publish(Event event) {
        Set<Listener<?>> matchedListeners = getMatchedListeners(event);
        for (Listener<?> listener : matchedListeners) {
            Executor executor = getTaskExecutor();
            if (executor != null) {
                // 如果外界设置了线程池，则变为异步事件
                executor.execute(() -> invokeListener(listener, event));
            } else {
                // 默认同步事件
                invokeListener(listener, event);
            }
        }
    }

    // ------------- private methods -------------
    private Set<Listener<?>> getMatchedListeners(Event event) {
        if (listeners.isEmpty()) {
            return Collections.emptySet();
        }

        return listeners.stream()
                .filter(listener -> listener.supportsEventType(event))
                .collect(Collectors.toSet());
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void invokeListener(Listener listener, Event event) {
        listener.onApplicationEvent(event);
    }

    @Nullable
    public Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    public void setTaskExecutor(@Nullable Executor executor) {
        this.taskExecutor = executor;
    }

}