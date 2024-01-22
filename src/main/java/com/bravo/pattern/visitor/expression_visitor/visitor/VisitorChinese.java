package com.bravo.pattern.visitor.expression_visitor.visitor;

import com.bravo.pattern.visitor.expression_visitor.expression.AddExpression;
import com.bravo.pattern.visitor.expression_visitor.expression.NumberExpression;
import com.bravo.pattern.visitor.expression_visitor.expression.SubtractExpression;

public class VisitorChinese implements Visitor {
    private final StringBuilder sb = new StringBuilder();

    public String getResult() {
        return sb.toString();
    }

    public void visit(NumberExpression expression) {
        int num = expression.interpret();
        String[] chineseDigits = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        char[] digits = String.valueOf(num).toCharArray();
        for (char digit : digits) {
            sb.append(chineseDigits[Character.getNumericValue(digit)]);
        }
    }

    public void visit(AddExpression expression) {
        expression.left.accept(this);
        sb.append("加");
        expression.right.accept(this);
    }

    public void visit(SubtractExpression expression) {
        expression.left.accept(this);
        sb.append("减");
        expression.right.accept(this);
    }
}