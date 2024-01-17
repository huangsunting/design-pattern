package com.bravo.pattern.chain.verifier.refactor3.verifychain;

import com.bravo.pattern.chain.verifier.refactor3.support.ChannelEnum;
import com.bravo.pattern.chain.verifier.refactor3.verifier.OrderConvertVerifier;
import com.bravo.pattern.chain.verifier.refactor3.verifier.common.ChannelRelationBindingVerifier;
import com.bravo.pattern.chain.verifier.refactor3.verifier.common.OrderNoConvertedVerifier;
import com.bravo.pattern.chain.verifier.refactor3.verifier.taobao.TaoBaoFirstConvertVerifier;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("taoBaoOrderConvertVerifyChainRefactor3")
public class TaoBaoOrderConvertVerifyChain extends AbstractOrderConvertVerifyChain implements BeanFactoryAware {

    private List<OrderConvertVerifier> verifiers;

    @Override
    public boolean match(Integer channel) {
        return ChannelEnum.TAO_BAO.getCode().equals(channel);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.verifiers = Arrays.asList(
                beanFactory.getBean(OrderNoConvertedVerifier.class),
                beanFactory.getBean(ChannelRelationBindingVerifier.class),
                beanFactory.getBean(TaoBaoFirstConvertVerifier.class)
        );
    }

    @Override
    protected List<OrderConvertVerifier> getVerifiers() {
        return verifiers;
    }
}