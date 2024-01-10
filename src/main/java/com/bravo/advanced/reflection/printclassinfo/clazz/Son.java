package com.bravo.advanced.reflection.printclassinfo.clazz;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.internal.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@MyAnnotation("annotation on Son")
public class Son extends Father implements MyInterface<Integer, String>, Serializable {

    // 4种修饰符的字段
    public String publicField;
    protected int protectedField;
    int defaultField;
    private int privateField;

    // 带注解的字段
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date annotatedField;

    public Son() {
    }

    // 公有构造
    public Son(int privateField) {
        this.privateField = privateField;
    }

    // 私有构造
    private Son(String publicField, int privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
    }

    // 接口实现
    @Override
    public String interfaceMethod(Integer param) {
        return param.toString();
    }

    // 带泛型的方法
    @RequestMapping("/son/sonPrivateMethod")
    private void sonPrivateMethod(@NotNull List<? extends Father> param) {
        System.out.println("Son私有方法, param:" + param);
    }

    @Override
    public String toString() {
        return "{" +
                "publicField='" + publicField + '\'' +
                ", protectedField=" + protectedField +
                ", defaultField=" + defaultField +
                ", privateField=" + privateField +
                ", annotatedField=" + annotatedField +
                "」";
    }
}