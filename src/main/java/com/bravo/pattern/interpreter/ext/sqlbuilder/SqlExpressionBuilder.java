package com.bravo.pattern.interpreter.ext.sqlbuilder;

import java.util.LinkedList;

public class SqlExpressionBuilder {
    private final LinkedList<String> parts = new LinkedList<>();

    private boolean isConditionAdded;

    SqlExpressionBuilder() {
        this.isConditionAdded = false;
    }

    public SqlExpressionBuilder eq(String column, String value) {
        if (isConditionAdded) {
            parts.add(" AND ");
        }
        parts.add(column + " = '" + value + "'");
        isConditionAdded = true;
        return this;
    }

    public SqlExpressionBuilder and(Condition condition) {
        if (isConditionAdded) {
            parts.add(" AND ");
        }
        parts.add("(");
        isConditionAdded = false;
        condition.apply(this);
        parts.add(")");
        return this;
    }

    public SqlExpressionBuilder or() {
        isConditionAdded = false;
        parts.add(" OR ");
        return this;
    }

    public SqlExpressionBuilder or(Condition condition) {
        if (isConditionAdded) {
            parts.add(" OR ");
        }
        parts.add("(");
        isConditionAdded = false;
        condition.apply(this);
        parts.add(")");
        return this;
    }

    public String build() {
        return String.join("", parts);
    }
}
