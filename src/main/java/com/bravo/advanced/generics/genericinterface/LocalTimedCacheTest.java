package com.bravo.advanced.generics.genericinterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LocalTimedCacheTest {

    @Test
    public void test() throws InterruptedException {
        LocalTimedCache<String> cache = new LocalTimedCache<>();
        cache.put("key", "value");
        cache.put("exKey", "exValue", Duration.ofSeconds(1));

        Assertions.assertNull(cache.get("a"));
        Assertions.assertEquals("value", cache.get("key"));
        Assertions.assertEquals("exValue", cache.get("exKey"));

        TimeUnit.SECONDS.sleep(2);

        Assertions.assertNull(cache.get("a"));
        Assertions.assertEquals("value", cache.get("key"));    // 一直有效
        Assertions.assertNull(cache.get("exKey"));                      // 1秒后过期，此时应该为null
    }
}
