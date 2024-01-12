package com.bravo.pattern.flyweight.impl1;

public class Integer {
    private final int value;

    private Integer(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public static Integer valueOf(int value) {
        if (value >= -128 && value <= 127) {
            return CACHE[value + 128];
        }
        return new Integer(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return value == ((Integer) obj).intValue();
        }
        return false;
    }

    // ------ 共享对象：类加载时初始化缓存池 ------
    private static final Integer[] CACHE;

    static {
        // 缓存-128~127的Integer对象，避免重复创建
        CACHE = new Integer[256];
        for (int i = 0; i < CACHE.length; i++) {
            CACHE[i] = new Integer(i - 128);
        }
    }
}