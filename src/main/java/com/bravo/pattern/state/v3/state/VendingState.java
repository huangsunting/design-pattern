package com.bravo.pattern.state.v3.state;


import com.bravo.pattern.state.v3.VendingMachine;

/**
 * 将machine从state剥离出去，通过传参再组合起来。这样各个state就可以设计成单例
 */
public interface VendingState {

    void insertCoin(VendingMachine machine);

    void selectGoods(VendingMachine machine);

    void dispense(VendingMachine machine);

}
