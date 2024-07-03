package com.bravo.advanced.generics.genericinterface;


import cn.hutool.core.lang.Pair;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

public class LocalTimedCache<T> implements Cache<T> {
    // 双层结构：key => (value => expiration)
    private final ConcurrentHashMap<String, Pair<T, Instant>> cache = new ConcurrentHashMap<>();

    @Override
    public void put(String key, T value) {
        cache.put(key, new Pair<>(value, null));
    }

    @Override
    public void put(String key, T value, Duration expiration) {
        cache.put(key, new Pair<>(value, Instant.now().plus(expiration)));
    }

    @Override
    public T get(String key) {
        Pair<T, Instant> entry = cache.get(key);
        if (entry == null) {
            // 没有对应缓存
            return null;
        }

        Instant expireTime = entry.getValue();
        if (expireTime == null) {
            // 没有设置过期时间
            return entry.getKey();
        } else if (expireTime.isAfter(Instant.now())) {
            // 未过期
            return entry.getKey();
        } else {
            // 已过期
            cache.remove(key);
            return null;
        }
    }

}