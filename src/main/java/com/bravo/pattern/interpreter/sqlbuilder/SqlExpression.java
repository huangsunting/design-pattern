package com.bravo.pattern.interpreter.sqlbuilder;

public class SqlExpression {
    private final String sql;

    SqlExpression(String sql) {
        this.sql = sql;
    }

    public static SqlExpressionBuilder builder() {
        return new SqlExpressionBuilder();
    }

    @Override
    public String toString() {
        return sql;
    }
}
