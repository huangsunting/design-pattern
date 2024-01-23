package com.bravo.pattern.interpreter.sqlbuilder;

@FunctionalInterface
public interface Condition {
    void apply(SqlExpressionBuilder builder);
}