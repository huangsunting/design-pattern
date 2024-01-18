package com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifyexecutor;

import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.OrderConvertRequest;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Result;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifychain.OrderConvertVerifyChain;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * VerifyChain：渠道内
 * VerifyExecutor：跨渠道
 *
 * 为什么VerifyChain用BeanFactoryAware注入Bean，而VerifyExecutor用Resource注入Bean？
 * 因为VerifyChain负责组装各个渠道内的校验逻辑，既有公共逻辑，又有渠道特有的逻辑，需要精细化操作，最好手动指定。
 * 而VerifyExecutor负责组装跨渠道的校验逻辑，每个渠道只有一个，直接注入即可。
 */
@Component("orderConvertVerifyExecutorRefactor3")
public class OrderConvertVerifyExecutor {

    @Resource
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
}