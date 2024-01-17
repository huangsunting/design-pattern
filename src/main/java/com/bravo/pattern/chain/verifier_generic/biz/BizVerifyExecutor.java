package com.bravo.pattern.chain.verifier_generic.biz;

import com.bravo.pattern.chain.verifier_generic.biz.support.BizRequest;
import com.bravo.pattern.chain.verifier_generic.jar.Result;
import com.bravo.pattern.chain.verifier_generic.biz.verifier.FirstVerifier;
import com.bravo.pattern.chain.verifier_generic.biz.verifier.SecondVerifier;
import com.bravo.pattern.chain.verifier_generic.jar.VerifyChainExecutor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class BizVerifyExecutor {

    @Resource
    private BeanFactory beanFactory;

    @Bean
    public VerifyChainExecutor<BizRequest, Result> bizVerifyChainExecutor() {
        return VerifyChainExecutor.<BizRequest, Result>builder()
                .add(beanFactory.getBean(FirstVerifier.class))
                .add(beanFactory.getBean(SecondVerifier.class))
                .build();
    }

}