package com.bravo.pattern.visitor.double_dispatch.inheritance;

import com.bravo.pattern.visitor.double_dispatch.visitor.Printer;

public class Son extends Father {

    @Override
    public void say() {
        System.out.println("say in Son");
    }

    public void accept(Printer printer) {
        printer.print(this);
    }
}