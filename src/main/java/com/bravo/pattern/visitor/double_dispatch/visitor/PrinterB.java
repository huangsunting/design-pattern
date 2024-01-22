package com.bravo.pattern.visitor.double_dispatch.visitor;


import com.bravo.pattern.visitor.double_dispatch.inheritance.Father;
import com.bravo.pattern.visitor.double_dispatch.inheritance.Son;

public class PrinterB implements Printer {

    public void print(Father father) {
        System.out.println("print father in PrinterB");
    }

    public void print(Son son) {
        System.out.println("print son in PrinterB");
    }

}
