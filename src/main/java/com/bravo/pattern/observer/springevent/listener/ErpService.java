package com.bravo.pattern.observer.springevent.listener;

import com.bravo.pattern.observer.springevent.event.Event;
import com.bravo.pattern.observer.springevent.event.OrderCompletedEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 物流服务，监听下单事件，用户下单后发货
 */
@Slf4j
public class ErpService implements Listener<OrderCompletedEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderCompletedEvent event) {
        TimeUnit.SECONDS.sleep(2);
        log.info("订单{}已经发货！", event.getSource());
    }

    @Override
    public boolean supportsEventType(Event event) {
        return event instanceof OrderCompletedEvent;
    }
}