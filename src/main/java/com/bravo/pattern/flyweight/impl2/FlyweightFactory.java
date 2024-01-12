package com.bravo.pattern.flyweight.impl2;

import com.bravo.pattern.flyweight.impl2.pojo.SchoolInfo;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    private FlyweightFactory() {
    }

    private static final Map<String, SchoolInfo> SCHOOL_INFO_CACHE = new HashMap<>();

    public static SchoolInfo getSchoolInfo(String name, String address, String slogan) {
        String key = name + address + slogan;
        return SCHOOL_INFO_CACHE.computeIfAbsent(key, k -> new SchoolInfo(name, address, slogan));
    }


    // 这个方法不是必需的，只是为了打印缓存内容
    public static void printCache() {
        System.out.println("SchoolInfo Cache: " + SCHOOL_INFO_CACHE);
    }
}