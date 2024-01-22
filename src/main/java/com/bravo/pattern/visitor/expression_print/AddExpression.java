package com.bravo.pattern.visitor.expression_print;

public class AddExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }

    @Override
    public String print() {
        return left.print() + "+" + right.print();
    }
}
