package com.bravo.pattern.chain_of_responsibility.verifier.refactor1;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 重构1：分离参数校验与业务校验、做了一些简单的函数封装
 */
public class OrderConvertService {

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
        if (this.checkIfOrderNoConverted(request.getOrderNo())) {
            throw new RuntimeException("订单已被转换");
        }
        if (this.checkUserChannelRelation(request.getOrderNo(), request.getChannel(), request.getUserId())) {
            throw new RuntimeException("账号已被绑定");
        }
    }

    private boolean checkUserChannelRelation(String orderNo, Integer channel, Long userId) {
        // 省略逻辑...
        return ThreadLocalRandom.current().nextBoolean();
    }

    private boolean checkIfOrderNoConverted(String orderNo) {
        // 省略逻辑...
        return ThreadLocalRandom.current().nextBoolean();
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