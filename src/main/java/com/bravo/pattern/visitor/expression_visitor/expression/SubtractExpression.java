package com.bravo.pattern.visitor.expression_visitor.expression;

import com.bravo.pattern.visitor.expression_visitor.visitor.Visitor;
import lombok.Getter;

public class SubtractExpression implements Expression {
    // 提供getter，这样Visitor才能访问
    @Getter
    private final Expression left;
    @Getter
    private final Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
