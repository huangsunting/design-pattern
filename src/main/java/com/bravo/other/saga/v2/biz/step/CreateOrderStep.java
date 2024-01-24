package com.bravo.other.saga.v2.biz.step;

import com.bravo.other.saga.v2.biz.Context;
import com.bravo.other.saga.v2.jar.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Component("createOrderStepV2")
public class CreateOrderStep implements Step<Context> {
    @Override
    public void execute(Context context) {
        String orderId = context.getRequestProdId() + "_" + ThreadLocalRandom.current().nextLong(10000);
        log.info("订单创建, orderId:{}", orderId);
        context.setContextOrderId(orderId);
    }

    @Override
    public void rollback(Context context) {
        String orderId = context.getContextOrderId();
        if (orderId != null) {
            log.info("取消订单, orderId:{}", orderId);
        }
    }
}
