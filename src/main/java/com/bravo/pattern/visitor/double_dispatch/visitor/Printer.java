package com.bravo.pattern.visitor.double_dispatch.visitor;

import com.bravo.pattern.visitor.double_dispatch.inheritance.Father;
import com.bravo.pattern.visitor.double_dispatch.inheritance.Son;

public interface Printer {

    void print(Father father);

    void print(Son son);

}