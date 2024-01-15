package com.bravo.pattern.springevent;

import com.bravo.pattern.observer.springevent.ApplicationContext;
import com.bravo.pattern.observer.springevent.event.OrderCompletedEvent;
import com.bravo.pattern.observer.springevent.listener.ErpService;
import com.bravo.pattern.observer.springevent.listener.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class EventTest {

    // 依赖ApplicationContext
    private final ApplicationContext applicationContext = new ApplicationContext();

    // 模拟Spring启动，初始化容器并注册bean
    @BeforeEach
    public void refreshApplication() {
        applicationContext.registerListener(new SmsService());
        applicationContext.registerListener(new ErpService());
        // applicationContext.registerListener(new RefundService());
        applicationContext.setTaskExecutor(Executors.newFixedThreadPool(2));
    }

    // 模拟OrderService#order()
    @Test
    public void orderCompletedService() throws InterruptedException {
        // 扣减库存...

        // 生成订单... orderId=10086

        // 订单流水...

        // 下单成功，发布事件
        applicationContext.publish(new OrderCompletedEvent(10086L));
        log.info("OrderService#order()结束");

        TimeUnit.SECONDS.sleep(10);
    }

}