package com.bravo.pattern.interpreter.ext.conditionbuilder.expression;

import com.bravo.pattern.interpreter.ext.conditionbuilder.Context;

// EQ逻辑（终结符号）
public class EqualsExpression implements Expression {
    private final String key;
    private final String value;

    public EqualsExpression(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean evaluate(Context context) {
        return context.getVariable(key).equals(value);
    }
}