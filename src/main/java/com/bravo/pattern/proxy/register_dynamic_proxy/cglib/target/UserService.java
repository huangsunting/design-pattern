package com.bravo.pattern.proxy.register_dynamic_proxy.cglib.target;

import com.bravo.pattern.proxy.metric.Metric;
import com.bravo.pattern.proxy.register_dynamic_proxy.jdk.target.IUserService;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class UserService implements IUserService {

    @Metric(bizTag = "user", bizSubTag = "user_register")
    @Override
    public Long register(String nickname, String mobile, String sex) {
        // 业务逻辑
        sleep(ThreadLocalRandom.current().nextInt(3));
        log.info("UserService#register 注册成功, nickname:{}, mobile:{}, sex:{}", nickname, mobile, sex);
        return 10086L;
    }

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            log.error("sleep exception", e);
        }
    }
}