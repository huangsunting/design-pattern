package com.bravo.pattern.memento.modifier.mypackage;

// 公共访问权限：谁都可以访问MainClass
public class MainClass {
    // 包访问权限
    String packageField;
    // 公共访问权限
    public String publicField;

    public void publicMethod() {

    }

    void packageMethod() {

    }

    public MainClass() {
    }

    public MainClass(String packageField, String publicField) {
        this.packageField = packageField;
        this.publicField = publicField;
    }
}