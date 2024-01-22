package com.bravo.pattern.visitor.double_dispatch.inheritance;

import com.bravo.pattern.visitor.double_dispatch.visitor.Printer;

public class Father {

    public void say() {
        System.out.println("say in Father");
    }

    public void accept(Printer printer) {
        printer.print(this);
    }
}
