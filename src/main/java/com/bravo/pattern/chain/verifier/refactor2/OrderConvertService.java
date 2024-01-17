package com.bravo.pattern.chain.verifier.refactor2;

import com.bravo.pattern.chain.verifier.refactor2.support.OrderConvertRequest;
import com.bravo.pattern.chain.verifier.refactor2.support.Result;
import com.bravo.pattern.chain.verifier.refactor2.verifychain.OrderConvertVerifyChain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 重构2：将业务校验抽取到Verifier，并用VerifyChain串联
 */
@Service("orderConvertServiceRefactor2")
public class OrderConvertService {

    @Resource
    private OrderConvertVerifyChain orderConvertVerifyChain;

    public boolean convert(OrderConvertRequest request) {
        // 参数校验
        request.validate();

        // 业务校验
        this.bizCheck(request);

        // 保存转换记录
        this.saveConvertRecord(request.getOrderNo(), request.getChannel(), request.getUserId());

        // 发放积分
        long points = this.calculatePoints(request.getOrderNo(), request.getChannel());
        return this.sendPoints(request.getUserId(), points);
    }

    private void bizCheck(OrderConvertRequest request) {
        Result result = orderConvertVerifyChain.verify(request);
        if (!result.isPass()) {
            throw new RuntimeException(result.getErrMsg());
        }
    }

    private void saveConvertRecord(String orderNo, Integer channel, Long userId) {
        // 省略逻辑...
    }

    private long calculatePoints(String orderNo, Integer channel) {
        // 省略逻辑...
        return 0;
    }

    private boolean sendPoints(Long userId, long points) {
        // 省略逻辑...
        return true;
    }
}