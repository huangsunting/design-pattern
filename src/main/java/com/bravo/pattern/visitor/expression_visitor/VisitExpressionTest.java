package com.bravo.pattern.visitor.expression_visitor;

import com.bravo.pattern.visitor.expression_visitor.expression.AddExpression;
import com.bravo.pattern.visitor.expression_visitor.expression.Expression;
import com.bravo.pattern.visitor.expression_visitor.expression.NumberExpression;
import com.bravo.pattern.visitor.expression_visitor.expression.SubtractExpression;
import com.bravo.pattern.visitor.expression_visitor.visitor.VisitorChinese;
import com.bravo.pattern.visitor.expression_visitor.visitor.VisitorJapanese;
import com.bravo.pattern.visitor.expression_visitor.visitor.VisitorMath;


public class VisitExpressionTest {

    public static void main(String[] args) {
        Expression expression = new SubtractExpression(
                new AddExpression(new NumberExpression(1), new NumberExpression(2)),
                new NumberExpression(3)
        );

        VisitorMath visitorMath = new VisitorMath();
        expression.accept(visitorMath);
        System.out.println("visitorMath: " + visitorMath.getResult());

        VisitorChinese visitorChinese = new VisitorChinese();
        expression.accept(visitorChinese);
        System.out.println("visitorChinese: " + visitorChinese.getResult());

        VisitorJapanese visitorJapanese = new VisitorJapanese();
        expression.accept(visitorJapanese);
        System.out.println("visitorJapanese: " + visitorJapanese.getResult());
    }
}
