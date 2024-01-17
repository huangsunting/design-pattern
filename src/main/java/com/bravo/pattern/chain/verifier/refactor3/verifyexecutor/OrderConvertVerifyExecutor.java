package com.bravo.pattern.chain.verifier.refactor3.verifyexecutor;

import com.bravo.pattern.chain.verifier.refactor3.support.OrderConvertRequest;
import com.bravo.pattern.chain.verifier.refactor3.support.Result;
import com.bravo.pattern.chain.verifier.refactor3.verifychain.DouYinOrderConvertVerifyChain;
import com.bravo.pattern.chain.verifier.refactor3.verifychain.OrderConvertVerifyChain;
import com.bravo.pattern.chain.verifier.refactor3.verifychain.TaoBaoOrderConvertVerifyChain;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("orderConvertVerifyExecutorRefactor3")
public class OrderConvertVerifyExecutor implements BeanFactoryAware {

    private List<OrderConvertVerifyChain> orderConvertVerifyChains;

    public Result verify(OrderConvertRequest request) {
        for (OrderConvertVerifyChain orderConvertVerifyChain : orderConvertVerifyChains) {
            // 根据入参channel，匹配对应渠道的VerifyChain，执行并返回校验结果
            if (orderConvertVerifyChain.match(request.getChannel())) {
                return orderConvertVerifyChain.verify(request);
            }
        }
        throw new RuntimeException("渠道暂未接入");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.orderConvertVerifyChains = Arrays.asList(
                beanFactory.getBean(TaoBaoOrderConvertVerifyChain.class),
                beanFactory.getBean(DouYinOrderConvertVerifyChain.class)
        );
    }
}