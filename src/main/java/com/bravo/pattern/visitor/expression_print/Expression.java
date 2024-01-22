package com.bravo.pattern.visitor.expression_print;

public interface Expression {
    int interpret();

    // 新增接口方法
    String print();
}