package com.bravo.pattern.interpreter.pattern.expression;

import com.bravo.pattern.interpreter.pattern.Context;

public class VariableExpression implements Expression {
    private final char variable;

    public VariableExpression(char variable) {
        this.variable = variable;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(variable);
    }
}