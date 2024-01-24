package com.bravo.other.saga.v3.biz;

import com.bravo.other.saga.v3.biz.step.CreateOrderStep;
import com.bravo.other.saga.v3.biz.step.UpdateStockStep;
import com.bravo.other.saga.v3.biz.step.UseCouponStep;
import com.bravo.other.saga.v3.biz.support.OrderContext;
import com.bravo.other.saga.v3.biz.support.OrderRequest;
import com.bravo.other.saga.v3.biz.support.OrderResult;
import com.bravo.other.saga.v3.jar.Pipeline;
import com.bravo.other.saga.v3.jar.Saga;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Slf4j
@Configuration("orderServiceV3")
public class OrderService {

    @Resource
    private BeanFactory beanFactory;

    public void execute(Pipeline<OrderRequest, OrderResult, OrderContext> pipeline) {
        this.orderSage().execute(pipeline);
    }

    @Bean
    public Saga<OrderRequest, OrderResult, OrderContext> orderSage() {
        log.info("init orderSage");
        return Saga.<OrderRequest, OrderResult, OrderContext>builder()
                .addStage(beanFactory.getBean(CreateOrderStep.class))
                .addStage(beanFactory.getBean(UpdateStockStep.class))
                .addStage(beanFactory.getBean(UseCouponStep.class))
                .build();
    }
}
