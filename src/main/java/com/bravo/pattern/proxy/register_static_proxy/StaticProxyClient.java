package com.bravo.pattern.proxy.register_static_proxy;


import com.bravo.pattern.proxy.register_static_proxy.proxy.ProxyUserService;
import com.bravo.pattern.proxy.register_static_proxy.target.UserService;

public class StaticProxyClient {

    public static void main(String[] args) {
        ProxyUserService proxyUserService = new ProxyUserService(new UserService());
        proxyUserService.register("bravo1988", "18257555555", "male");
    }
}
