package com.bravo.pattern.interpreter.ext.conditionlazybuilder;

import com.bravo.pattern.interpreter.ext.conditionlazybuilder.expression.AndExpression;
import com.bravo.pattern.interpreter.ext.conditionlazybuilder.expression.EqualsExpression;
import com.bravo.pattern.interpreter.ext.conditionlazybuilder.expression.Expression;
import com.bravo.pattern.interpreter.ext.conditionlazybuilder.expression.OrExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConditionExpressionBuilder {
    private final List<Expression> expressions = new ArrayList<>();

    private ConditionExpressionBuilder() {
    }

    public static ConditionExpressionBuilder builder() {
        return new ConditionExpressionBuilder();
    }

    public ConditionExpressionBuilder eq(String key, String value) {
        expressions.add(new EqualsExpression(key, value));
        return this;
    }

    public ConditionExpressionBuilder and(Consumer<ConditionExpressionBuilder> consumer) {
        ConditionExpressionBuilder builder = new ConditionExpressionBuilder();
        consumer.accept(builder);
        expressions.add(new AndExpression(builder.expressions));
        return this;
    }

    public ConditionExpressionBuilder or(Consumer<ConditionExpressionBuilder> consumer) {
        ConditionExpressionBuilder builder = new ConditionExpressionBuilder();
        consumer.accept(builder);
        expressions.add(new OrExpression(builder.expressions));
        return this;
    }

    public Expression build() {
        return new AndExpression(expressions);
    }
}
