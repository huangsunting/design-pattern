package com.bravo.pattern.interpreter.ext.conditionlazybuilder.expression;

import com.bravo.pattern.interpreter.ext.conditionlazybuilder.Context;

// 表达式抽象
public interface Expression {
    boolean evaluate(Context context);
}
