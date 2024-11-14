package com.bravo.advanced.generics.typeerasure;

import lombok.Data;
import lombok.Getter;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * TypeReferenceTest用于论述 “TypeReference为什么这么设计”：提供一种便捷的方式保存类型信息，用于fastjson反序列化目标对象。
 */
public class TypeReferenceTest {

    @Test
    public void testGetTypeInfo() {
        // 反序列化简单对象
        // Obj obj = JSON.parseObject("{}", Obj.class);

        // 反序列化泛型对象
        GenericObj<String> genericObj = JSON.parseObject("{}", new TypeReference<GenericObj<String>>() {
        });
    }

    /**
     * 仿写fastjson
     */
    static class JSON {

        @SneakyThrows
        public static <T> T parseObject(String json, Class<T> clazz) {
            // 1.反射创建对象
            T obj = clazz.newInstance();
            System.out.println(obj);

            // 2.解析json，得到每一个field的key、value
            // ...

            return obj;
        }

        @SuppressWarnings("unchecked")
        @SneakyThrows
        public static <T> T parseObject(String json, TypeReference<T> typeReference) {
            // type = clazz + typeArgument
            ParameterizedType type = (ParameterizedType) typeReference.getType();
            System.out.println(type.getTypeName());

            // clazz
            Class<T> clazz = (Class<T>) type.getRawType();
            System.out.println(clazz.getName());

            // typeArgument
            Type actualTypeArgument = type.getActualTypeArguments()[0];
            System.out.println(actualTypeArgument);

            // 1.反射创建对象
            T genericObj = clazz.newInstance();
            System.out.println(genericObj);

            // 2.解析json，得到每一个field的key、value
            // ...

            return genericObj;
        }
    }

    /**
     * 仿写fastjson的TypeReference
     *
     * @param <T> 反序列化目标对象类型
     */
    @Getter
    static abstract class TypeReference<T> {
        private final Type type;

        public TypeReference() {
            // 无论继承还是使用匿名对象，创建出来的都是TypeReference的子类实例
            // this.getClass()得到的事TypeReference子类的Class，this.getClass().getGenericSuperclass()得到则是 TypeReference<T> 自身Class
            Type typeRefClazz = this.getClass().getGenericSuperclass();
            // 又由于Java会保留继承中的泛型信息，所以这里可以获取 GenericSuperclass 的泛型参数，也就是T，也就是GenericObj<K>整体信息
            type = ((ParameterizedType) typeRefClazz).getActualTypeArguments()[0];
        }
    }

    // ===== 反序列化目标对象：普通对象、泛型对象 =====

    @Data
    static class GenericObj<K> {
        private K other;
        private String name;
    }

    @Data
    static class Obj {
        private Long id;
        private String name;
    }

}
