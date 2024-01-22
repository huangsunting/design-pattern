package com.bravo.pattern.visitor.expression_print;

public class NumberExpression implements Expression {
    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }

    @Override
    public String print() {
        return Integer.toString(number);
    }
}