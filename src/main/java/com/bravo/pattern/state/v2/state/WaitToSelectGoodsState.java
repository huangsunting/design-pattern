package com.bravo.pattern.state.v2.state;


import com.bravo.pattern.state.v2.VendingMachine;

// 等待选品
public class WaitToSelectGoodsState implements VendingState {

    private final VendingMachine vendingMachine;

    public WaitToSelectGoodsState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("UNSUPPORTED OPERATION：已投币，请选择商品");
    }

    @Override
    public void selectGoods() {
        // 委托给machine统一切换
        vendingMachine.nextState();
        System.out.println("选中XX商品");
    }

    @Override
    public void dispense() {
        System.out.println("UNSUPPORTED OPERATION：未选择商品，无法出货");
    }
}