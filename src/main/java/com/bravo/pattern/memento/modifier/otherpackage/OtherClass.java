package com.bravo.pattern.memento.modifier.otherpackage;

import com.bravo.pattern.memento.modifier.mypackage.MainClass;

public class OtherClass {

    public static void main(String[] args) {
        // 可以访问
        MainClass mainClass = new MainClass();
        // 编译报错：SubClass is not public, cannot be accessed from outside package
        // SubClass subClass = new SubClass();
    }
    
}