package com.bravo.advanced.generic.genericinterface;

import java.time.Duration;

public interface Cache<T> {

    void put(String key, T value);

    void put(String key, T value, Duration expiration);

    T get(String key);
}