package com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifyexecutor;

import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.OrderConvertRequest;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.support.Result;
import com.bravo.pattern.chain_of_responsibility.verifier.refactor3.verifychain.OrderConvertVerifyChain;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * VerifyExecutor是什么？
 * - 第一个层次：Verifier，独立的校验逻辑
 * - 第二个层次：VerifyChain，同一渠道下串联的多个校验逻辑
 * - 第三个层次：VerifyExecutor，业务接口的校验逻辑，包含多渠道（淘宝、抖音...）
 *
 * 前端请求的统一入口是OrderConvertService#convert，内部依赖VerifyExecutor进行业务校验。
 * request ==> OrderConvertService#convert ==> VerifyExecutor#verify（渠道匹配） ==> VerifyChain#verify（渠道校验）
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