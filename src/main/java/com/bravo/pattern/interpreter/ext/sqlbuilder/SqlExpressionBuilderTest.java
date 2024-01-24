package com.bravo.pattern.interpreter.ext.sqlbuilder;

public class SqlExpressionBuilderTest {

    public static void main(String[] args) {
        String sql = SqlExpression.builder()
                .eq("name", "bravo")
                .eq("age", "18")
                .and(x -> {
                    x.eq("weight", "60").or().eq("height", "170").or().eq("id", "10086");
                })
                .or(x -> {
                    x.eq("a", "1").eq("b", "2");
                })
                .build();
        // name = 'bravo' AND age = '18' AND (weight = '60' OR height = '170' OR id = '10086') OR (a = '1' AND b = '2')
        System.out.println(sql);
    }
}