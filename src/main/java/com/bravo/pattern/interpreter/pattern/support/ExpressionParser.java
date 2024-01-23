package com.bravo.pattern.interpreter.pattern.support;

import com.bravo.pattern.interpreter.pattern.expression.AdditionExpression;
import com.bravo.pattern.interpreter.pattern.expression.DivisionExpression;
import com.bravo.pattern.interpreter.pattern.expression.Expression;
import com.bravo.pattern.interpreter.pattern.expression.MultiplicationExpression;
import com.bravo.pattern.interpreter.pattern.expression.SubtractionExpression;
import com.bravo.pattern.interpreter.pattern.expression.VariableExpression;

import java.util.Stack;

public class ExpressionParser {

    public static Expression parse(String input) {
        Stack<Expression> expressionStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operatorStack.isEmpty() && hasPrecedence(c, operatorStack.peek())) {
                    Expression right = expressionStack.pop();
                    Expression left = expressionStack.pop();
                    char operator = operatorStack.pop();
                    expressionStack.push(createExpression(left, right, operator));
                }
                operatorStack.push(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    Expression right = expressionStack.pop();
                    Expression left = expressionStack.pop();
                    char operator = operatorStack.pop();
                    expressionStack.push(createExpression(left, right, operator));
                }
                operatorStack.pop();
            } else {
                expressionStack.push(new VariableExpression(c));
            }
        }

        while (!operatorStack.isEmpty()) {
            Expression right = expressionStack.pop();
            Expression left = expressionStack.pop();
            char operator = operatorStack.pop();
            expressionStack.push(createExpression(left, right, operator));
        }

        return expressionStack.pop();
    }

    // 私有
    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    // 私有
    private static Expression createExpression(Expression left, Expression right, char operator) {
        switch (operator) {
            case '+':
                return new AdditionExpression(left, right);
            case '-':
                return new SubtractionExpression(left, right);
            case '*':
                return new MultiplicationExpression(left, right);
            case '/':
                return new DivisionExpression(left, right);
            default:
                return null;
        }
    }
}