package com.bravo.pattern.strategy.classical;

public class StrategyTest {

    public static void main(String[] args) {
        // 可以初始化指定策略
        Context context = new Context(new Add());

        int addResult = context.executeStrategy(2, 1);
        System.out.println("result:" + addResult);

        // 也可以替换策略
        context.setStrategy(new Sub());

        int subResult = context.executeStrategy(2, 1);
        System.out.println("result:" + subResult);
    }
}