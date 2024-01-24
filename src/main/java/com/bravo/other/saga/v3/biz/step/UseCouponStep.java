package com.bravo.other.saga.v3.biz.step;


import com.bravo.other.saga.v3.biz.support.OrderContext;
import com.bravo.other.saga.v3.biz.support.OrderRequest;
import com.bravo.other.saga.v3.biz.support.OrderResult;
import com.bravo.other.saga.v3.jar.Pipeline;
import com.bravo.other.saga.v3.jar.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("useCouponStepV3")
public class UseCouponStep implements Step<OrderRequest, OrderResult, OrderContext> {
    // 数据库查询用户优惠券
    private Long couponId = 123456L;

    @Override
    public void process(Pipeline<OrderRequest, OrderResult, OrderContext> pipeline) {
        log.info("使用优惠券, couponId:{}", couponId);
        couponId = null;
        pipeline.getContext().setCouponId(couponId);
    }

    @Override
    public void rollback(Pipeline<OrderRequest, OrderResult, OrderContext> pipeline) {
        Long usedCouponId = pipeline.getContext().getCouponId();
        if (usedCouponId != null) {
            log.info("回滚优惠券, couponId:{}", usedCouponId);
            couponId = usedCouponId;
        }
    }
}