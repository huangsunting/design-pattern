package com.bravo.other.saga.v3;

import com.bravo.other.saga.v3.biz.OrderService;
import com.bravo.other.saga.v3.biz.support.OrderContext;
import com.bravo.other.saga.v3.biz.support.OrderRequest;
import com.bravo.other.saga.v3.biz.support.OrderResult;
import com.bravo.other.saga.v3.jar.Pipeline;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class SagaClientV3 {

    @Resource(name = "orderServiceV3")
    private OrderService orderService;

    @Test
    public void userOrderRequest() {
        OrderRequest orderRequest = new OrderRequest(10086L, 3);
        OrderResult orderResult = new OrderResult();
        OrderContext orderContext = new OrderContext();
        Pipeline<OrderRequest, OrderResult, OrderContext> pipeline = new Pipeline<>(orderRequest, orderResult, orderContext);
        orderService.execute(pipeline);
        log.info("orderResult:{}", pipeline.getResponse());
    }
}