package com.bravo.pattern.observer.springevent.listener;

import com.bravo.pattern.observer.springevent.event.Event;
import com.bravo.pattern.observer.springevent.event.OrderCompletedEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 短信服务，监听下单事件，下单后发短信通知用户
 */
@Slf4j
public class SmsService implements Listener<OrderCompletedEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderCompletedEvent event) {
        TimeUnit.SECONDS.sleep(2);
        log.info("下单成功！您的订单号是:{}", event.getSource());
    }

    @Override
    public boolean supportsEventType(Event event) {
        return event instanceof OrderCompletedEvent;
    }
}

