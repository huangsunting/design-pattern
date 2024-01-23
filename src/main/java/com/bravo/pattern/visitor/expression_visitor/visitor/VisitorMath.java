package com.bravo.pattern.visitor.expression_visitor.visitor;

import com.bravo.pattern.visitor.expression_visitor.expression.AddExpression;
import com.bravo.pattern.visitor.expression_visitor.expression.NumberExpression;
import com.bravo.pattern.visitor.expression_visitor.expression.SubtractExpression;

public class VisitorMath implements Visitor {
    private final StringBuilder sb = new StringBuilder();

    public String getResult() {
        return sb.toString();
    }

    public void visit(NumberExpression expression) {
        sb.append(expression.interpret());
    }

    public void visit(AddExpression expression) {
        expression.getLeft().accept(this);
        sb.append("+");
        expression.getRight().accept(this);
    }

    public void visit(SubtractExpression expression) {
        expression.getLeft().accept(this);
        sb.append("-");
        expression.getRight().accept(this);
    }
}
