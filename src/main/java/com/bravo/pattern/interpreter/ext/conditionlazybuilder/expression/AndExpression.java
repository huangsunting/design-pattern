package com.bravo.pattern.interpreter.ext.conditionlazybuilder.expression;

import com.bravo.pattern.interpreter.ext.conditionlazybuilder.Context;

import java.util.List;

// AND逻辑（非终结符号）
public class AndExpression implements Expression {
    private final List<Expression> expressions;

    public AndExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public boolean evaluate(Context context) {
        for (Expression expression : expressions) {
            if (!expression.evaluate(context)) {
                return false;
            }
        }
        return true;
    }
}