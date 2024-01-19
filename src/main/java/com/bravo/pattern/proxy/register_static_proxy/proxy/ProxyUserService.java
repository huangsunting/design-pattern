package com.bravo.pattern.proxy.register_static_proxy.proxy;

import com.bravo.pattern.proxy.metric.MetricTagEnum;
import com.bravo.pattern.proxy.metric.MetricTagSetter;
import com.bravo.pattern.proxy.metric.MetricUtil;
import com.bravo.pattern.proxy.register_static_proxy.target.IUserService;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 静态代理类，需要自己手动编写
 */
@Slf4j
public class ProxyUserService implements IUserService { // ProxyUserService实现IUserService

    private final IUserService userService; // 同时持有UserService引用（是不是和装饰器模式很像？）

    public ProxyUserService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public Long register(String nickname, String mobile, String sex) {
        return MetricUtil.metric(() -> userService.register(nickname, mobile, sex), new MetricTagSetter<Long>() {
            @Override
            public void apply(Long result, Map<MetricTagEnum, String> initialTagMap) {
                log.info("ProxyUserService#register result: {}", result);
                initialTagMap.put(MetricTagEnum.BIZ_TAG, "user");
                initialTagMap.put(MetricTagEnum.BIZ_SUB_TAG, "user_register");
            }
        });
    }
}