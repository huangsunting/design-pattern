package com.bravo.advanced.generics.typereference;

import lombok.Data;
import lombok.Getter;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeReferenceTest {

    @Test
    public void testGetTypeInfo() {
        // Obj obj = JSON.parseObject("{}", Obj.class);

        GenericObj<String> genericObj = JSON.parseObject("{}", new TypeReference<GenericObj<String>>() {
        });
    }

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

    // 子类继承、或使用匿名对象，都可以获取到参数化类型
    @Getter
    static class TypeReference<T> {
        private final Type type;

        public TypeReference() {
            Type superClass = this.getClass().getGenericSuperclass();
            type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        }
    }

    @Data
    static class GenericObj<T> {
        private T other;
        private String name;
    }

    @Data
    static class Obj {
        private Long id;
        private String name;
    }

}
