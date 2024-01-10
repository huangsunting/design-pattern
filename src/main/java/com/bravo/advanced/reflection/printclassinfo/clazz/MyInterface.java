package com.bravo.advanced.reflection.printclassinfo.clazz;

@FunctionalInterface
@MyAnnotation("annotation on MyInterface")
public interface MyInterface<T, R> {
    R interfaceMethod(T param);
}
