package com.bravo.pattern.visitor.expression_print;


public class PrintExpressionTest {

    public static void main(String[] args) {
        Expression expression = new SubtractExpression(
                new AddExpression(new NumberExpression(1), new NumberExpression(2)),
                new NumberExpression(3)
        );

        String print = expression.print();
        System.out.println(print); // 打印：1+2-3
    }
}
