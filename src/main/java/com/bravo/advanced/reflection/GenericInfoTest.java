package com.bravo.advanced.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericInfoTest {
    public static void main(String[] args) {
        new Son();
        new Daughter();
    }
}

class Father<T> {
    public Father() {
        // this指向的子类型不确定，这里用?
        Class<?> subClass = this.getClass();
        
        // 得到子类的泛型父类，也就是Father<T>
        Type genericSuperclass = subClass.getGenericSuperclass();

        // 本质是ParameterizedTypeImpl，可以向下强转（实际开发时最好用instance of ParameterizedType判断一下）
        ParameterizedType parameterizedTypeSuperclass = (ParameterizedType) genericSuperclass;

        // 强转后可用的方法变多了，比如getActualTypeArguments()可以获取Father<T>的实际类型参数
        Type[] actualTypeArguments = parameterizedTypeSuperclass.getActualTypeArguments();

        // 由于Father类只有一个类型参数，直接actualTypeArguments[0]
        Class<?> actualTypeArgument = (Class<?>) actualTypeArguments[0];
        System.out.println(actualTypeArgument);
    }
}

class Son extends Father<String> {
}

class Daughter extends Father<Integer> {
}