package com.bravo.pattern.chain_of_responsibility.verifier_generic.biz;

import com.bravo.pattern.chain_of_responsibility.verifier_generic.biz.support.BizRequest;
import com.bravo.pattern.chain_of_responsibility.verifier_generic.jar.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("orderConvertService")
public class OrderConvertService {

    @Resource
    private BizVerifyExecutor bizVerifyExecutor;

    public boolean convert(BizRequest request) {
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

    private void bizCheck(BizRequest request) {
        Result result = bizVerifyExecutor.bizVerifyChainExecutor().execute(request);
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