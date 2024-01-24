package com.bravo.other.saga.v2;

import com.bravo.other.saga.v2.biz.Context;
import com.bravo.other.saga.v2.biz.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class SagaClientV2 {

    @Resource(name = "orderServiceV2")
    private OrderService orderService;

    @Test
    public void userOrderRequest() {
        Context context = new Context();
        context.setRequestProdId(10086L);
        context.setRequestBuyNum(3);

        orderService.createOrder(context);
    }
}