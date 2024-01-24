package com.bravo.other.saga.v2.biz;

import com.bravo.other.saga.v2.biz.step.CreateOrderStep;
import com.bravo.other.saga.v2.biz.step.UpdateStockStep;
import com.bravo.other.saga.v2.biz.step.UseCouponStep;
import com.bravo.other.saga.v2.jar.Saga;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;


@Slf4j
@Service("orderServiceV2")
public class OrderService implements BeanFactoryAware {

    private final Saga<Context> orderRequestSage = new Saga<>();

    public void createOrder(Context context) {
        this.orderRequestSage.execute(context);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        orderRequestSage.addStep(beanFactory.getBean(CreateOrderStep.class));
        orderRequestSage.addStep(beanFactory.getBean(UpdateStockStep.class));
        orderRequestSage.addStep(beanFactory.getBean(UseCouponStep.class));
        log.info("orderRequestSage 初始化完成");
    }
}
