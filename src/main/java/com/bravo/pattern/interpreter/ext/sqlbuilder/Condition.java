package com.bravo.pattern.interpreter.ext.sqlbuilder;

@FunctionalInterface
public interface Condition {
    void apply(SqlExpressionBuilder builder);
}