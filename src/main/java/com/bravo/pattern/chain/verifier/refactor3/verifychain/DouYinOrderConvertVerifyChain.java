package com.bravo.pattern.chain.verifier.refactor3.verifychain;

import com.bravo.pattern.chain.verifier.refactor3.support.ChannelEnum;
import com.bravo.pattern.chain.verifier.refactor3.verifier.OrderConvertVerifier;
import com.bravo.pattern.chain.verifier.refactor3.verifier.common.ChannelRelationBindingVerifier;
import com.bravo.pattern.chain.verifier.refactor3.verifier.common.OrderNoConvertedVerifier;
import com.bravo.pattern.chain.verifier.refactor3.verifier.douyin.DouYinFirstConvertVerifier;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("douYinOrderConvertVerifyChainRefactor3")
public class DouYinOrderConvertVerifyChain extends AbstractOrderConvertVerifyChain implements BeanFactoryAware {

    private List<OrderConvertVerifier> verifiers;

    @Override
    public boolean match(Integer channel) {
        return ChannelEnum.DOU_YIN.getCode().equals(channel);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.verifiers = Arrays.asList(
                beanFactory.getBean(OrderNoConvertedVerifier.class),
                beanFactory.getBean(ChannelRelationBindingVerifier.class),
                beanFactory.getBean(DouYinFirstConvertVerifier.class)
        );
    }

    @Override
    protected List<OrderConvertVerifier> getVerifiers() {
        return verifiers;
    }
}