package com.bravo.other.saga.v2.biz.step;

import com.bravo.other.saga.v2.biz.Context;
import com.bravo.other.saga.v2.jar.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("useCouponStepV2")
public class UseCouponStep implements Step<Context> {
    // 数据库查询用户优惠券
    private Long couponId = 123456L;

    @Override
    public void execute(Context context) {
        log.info("使用优惠券, couponId:{}", couponId);
        couponId = null;
        context.setContextCouponId(couponId);
    }

    @Override
    public void rollback(Context context) {
        Long usedCouponId = context.getContextCouponId();
        if (usedCouponId != null) {
            log.info("回滚优惠券, couponId:{}", usedCouponId);
            couponId = usedCouponId;
        }
    }
}