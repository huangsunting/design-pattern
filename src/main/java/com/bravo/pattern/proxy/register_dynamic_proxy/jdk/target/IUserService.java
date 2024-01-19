package com.bravo.pattern.proxy.register_dynamic_proxy.jdk.target;

import com.bravo.pattern.proxy.metric.Metric;

public interface IUserService {
	
    @Metric(bizTag = "user", bizSubTag = "user_register")
    Long register(String nickname, String mobile, String sex);
}