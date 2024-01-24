package com.bravo.pattern.interpreter.ext.conditionlazybuilder.expression;

import com.bravo.pattern.interpreter.ext.conditionlazybuilder.Context;

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
        return context.getValue(key).equals(value);
    }
}