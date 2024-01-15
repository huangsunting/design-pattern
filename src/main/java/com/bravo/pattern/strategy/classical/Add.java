package com.bravo.pattern.strategy.classical;

public class Add implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}