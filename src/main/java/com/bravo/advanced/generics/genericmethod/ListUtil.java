package com.bravo.advanced.generics.genericmethod;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型类/泛型接口：在[类上]声明类型，在[类中]使用类型
 * 泛型方法：在[方法上]声明类型，在[方法中]使用类型
 */
public class ListUtil /*<T>*/ {

    public static <T>/*将类型声明移到方法上（返回值前）*/ List<T> filter(List<T> list, Matcher<T> matcher) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (matcher.isMatch(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public <T, R> List<R> map(List<T> list, Mapper<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T element : list) {
            result.add(mapper.mapping(element));
        }
        return result;
    }

    public interface Mapper<T, R> {
        R mapping(T item);
    }

    public interface Matcher<T> {
        boolean isMatch(T item);
    }
}