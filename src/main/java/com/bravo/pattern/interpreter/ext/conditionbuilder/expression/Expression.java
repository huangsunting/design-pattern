package com.bravo.pattern.interpreter.ext.conditionbuilder.expression;

import com.bravo.pattern.interpreter.ext.conditionbuilder.Context;

// 表达式抽象
public interface Expression {
    boolean evaluate(Context context);
}
