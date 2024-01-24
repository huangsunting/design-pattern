package com.bravo.other.saga.v3.biz.step;

import com.bravo.other.saga.v3.biz.support.OrderContext;
import com.bravo.other.saga.v3.biz.support.OrderRequest;
import com.bravo.other.saga.v3.biz.support.OrderResult;
import com.bravo.other.saga.v3.jar.Pipeline;
import com.bravo.other.saga.v3.jar.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Component("createOrderStepV3")
public class CreateOrderStep implements Step<OrderRequest, OrderResult, OrderContext> {

    @Override
    public void process(Pipeline<OrderRequest, OrderResult, OrderContext> pipeline) {
        String orderId = pipeline.getRequest().getProdId() + "_" + ThreadLocalRandom.current().nextLong(10000);
        log.info("订单创建, orderId:{}", orderId);
        pipeline.getContext().setOrderId(orderId);
    }

    @Override
    public void rollback(Pipeline<OrderRequest, OrderResult, OrderContext> pipeline) {
        String orderId = pipeline.getContext().getOrderId();
        if (orderId != null) {
            log.info("取消订单, orderId:{}", orderId);
        }
    }
}
