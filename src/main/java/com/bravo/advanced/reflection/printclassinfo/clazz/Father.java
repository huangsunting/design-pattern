package com.bravo.advanced.reflection.printclassinfo.clazz;

@MyAnnotation("annotation on Father")
public class Father {

    private String fatherPrivateField;

    private String fatherPublicField;

    public String fatherPrivateMethod(String param) {
        return "";
    }

    public String fatherPublicMethod(String param) {
        return "";
    }
}