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
    static abstract class TypeReference<T> {
        private final Type type;

        public TypeReference() {
            // test案例中创建的是 TypeReference<T> 匿名对象，所以此处this就是 TypeReference<T> 的一个实例
            // 那么this.getClass()也就是匿名子类的Class，而最终this.getClass().getGenericSuperclass()得到的就是 TypeReference<T>
            Type superClass = this.getClass().getGenericSuperclass();
            // 又由于Java会保留继承中的泛型信息，所以这里可以获取 GenericSuperclass 的泛型参数，也就是T，也就是GenericObj<K>整体信息
            type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        }
    }

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
