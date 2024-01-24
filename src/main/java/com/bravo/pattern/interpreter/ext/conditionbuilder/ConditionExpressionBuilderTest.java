package com.bravo.pattern.interpreter.ext.conditionbuilder;

import com.bravo.pattern.interpreter.ext.conditionbuilder.expression.Expression;

public class ConditionExpressionBuilderTest {

    public static void main(String[] args) {
        // 1.假设这是数据库保存的 条件
        Expression expression = ConditionExpressionBuilder.builder()
                .eq("name", "bravo")
                .eq("age", "18")
                .or(x -> x.eq("weight", "60").eq("height", "190"))
                .build();

        // 2.假设这是前端传入的数据
        Context context = new Context();
        context.setVariable("name", "bravo");
        context.setVariable("age", "18");
        context.setVariable("weight", "60");
        context.setVariable("height", "180"); // 尽管height不匹配，但因为是or逻辑里的，所以结果仍为true

        // 3.用数据库的条件 去校验 前端传入的数据
        System.out.println(expression.evaluate(context));
    }
}