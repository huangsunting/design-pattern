package com.bravo.pattern.proxy.register_dynamic_proxy.cglib.target;

public interface IUserService {
	
    Long register(String nickname, String mobile, String sex);
}