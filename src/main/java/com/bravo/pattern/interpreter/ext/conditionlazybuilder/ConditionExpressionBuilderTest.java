package com.bravo.pattern.interpreter.ext.conditionlazybuilder;

import com.bravo.pattern.interpreter.ext.conditionlazybuilder.expression.Expression;

public class ConditionExpressionBuilderTest {

    public static void main(String[] args) {
        // 构建表达式
        Expression expression = ConditionExpressionBuilder.builder()
                .eq("name", "bravo")
                .eq("age", "18")
                .or(x -> x.eq("weight", "60").eq("height", "190"))
                .build();

        // 构建数据
        UserService userService = new UserService();
        Context context = new Context()
                .value("name", "bravo1988") // 由于这一步就不满足，所以userService::getUserAge不会执行
                .lazyValue("age", userService::getUserAge)
                .value("weight", "60")
                .value("height", "180");

        // 用表达式校验数据
        System.out.println(expression.evaluate(context));
    }

    static class UserService {
        public String getUserAge() {
            System.out.println("UserService#getUserAge被调用了");
            return "18";
        }
    }
}