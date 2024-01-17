package com.bravo.pattern.template_method;


import com.bravo.pattern.template_method.pattern.ArrayListAddTest;

public class TemplateClient {

    public static void main(String[] args) {
        ArrayListAddTest addTest = new ArrayListAddTest();
        // addTest.executeCode(); protected修饰符，只有同包或者子类才能访问
        addTest.templateMethod();
    }
}
