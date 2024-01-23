package com.bravo.pattern.interpreter.pattern.expression;

import com.bravo.pattern.interpreter.pattern.Context;

public interface Expression {
    // 把数据代入表达式，返回计算结果
    int interpret(Context context);
}
