package com.bravo.pattern.visitor.expression_visitor.visitor;


import com.bravo.pattern.visitor.expression_visitor.expression.AddExpression;
import com.bravo.pattern.visitor.expression_visitor.expression.NumberExpression;
import com.bravo.pattern.visitor.expression_visitor.expression.SubtractExpression;

public class VisitorJapanese implements Visitor {
    private final StringBuilder sb = new StringBuilder();

    public String getResult() {
        return sb.toString();
    }

    public void visit(NumberExpression expression) {
        int num = expression.interpret();
        String[] japaneseDigits = {"れい", "いち", "に", "さん", "よん", "ご", "ろく", "しち", "はち", "きゅう"};
        char[] digits = String.valueOf(num).toCharArray();
        for (char digit : digits) {
            sb.append(japaneseDigits[Character.getNumericValue(digit)]);
        }
    }

    public void visit(AddExpression expression) {
        expression.getLeft().accept(this);
        sb.append("足す");
        expression.getRight().accept(this);
    }

    public void visit(SubtractExpression expression) {
        expression.getLeft().accept(this);
        sb.append("引く");
        expression.getRight().accept(this);
    }
}
