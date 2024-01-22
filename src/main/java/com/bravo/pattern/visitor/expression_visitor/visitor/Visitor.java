package com.bravo.pattern.visitor.expression_visitor.visitor;

import com.bravo.pattern.visitor.expression_visitor.expression.AddExpression;
import com.bravo.pattern.visitor.expression_visitor.expression.NumberExpression;
import com.bravo.pattern.visitor.expression_visitor.expression.SubtractExpression;

public interface Visitor {
    void visit(NumberExpression expression);

    void visit(AddExpression expression);

    void visit(SubtractExpression expression);
}