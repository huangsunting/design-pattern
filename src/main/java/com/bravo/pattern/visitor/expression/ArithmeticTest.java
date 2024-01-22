package com.bravo.pattern.visitor.expression;

public class ArithmeticTest {

    public static void main(String[] args) {
        // 1+2-3
        Expression expression = new SubtractExpression(
            new AddExpression(new NumberExpression(1), new NumberExpression(2)), 
            new NumberExpression(3)
        );

        int result = expression.interpret();
        System.out.println(result); // 打印0
    }
}