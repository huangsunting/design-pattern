package com.bravo.pattern.interpreter.pattern;

import com.bravo.pattern.interpreter.pattern.expression.Expression;
import com.bravo.pattern.interpreter.pattern.support.ExpressionParser;

public class InterpreterTest {

    public static void main(String[] args) {
        // 表达式（前端传入）
        String expressionStr = "(d-c)*b*a";
        // Expression（后端解析）
        Expression expression = ExpressionParser.parse(expressionStr);

        // 上下文
        Context context = new Context();
        context.setValue('a', 3);
        context.setValue('b', 8);
        context.setValue('c', 8);
        context.setValue('d', 9);

        // 代入数据，解释表达式，得到结果
        int result = expression.interpret(context);
        System.out.println(result);
    }
}