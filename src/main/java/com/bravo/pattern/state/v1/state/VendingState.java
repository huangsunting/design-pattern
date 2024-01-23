package com.bravo.pattern.state.v1.state;

// 状态抽象：每种状态都有3个行为
public interface VendingState {
    void insertCoin();

    void selectGoods();

    void dispense();
}