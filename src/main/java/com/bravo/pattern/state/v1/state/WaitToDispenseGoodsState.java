package com.bravo.pattern.state.v1.state;

import com.bravo.pattern.state.v1.VendingMachine;

// 等待出货
public class WaitToDispenseGoodsState implements VendingState {

    private final VendingMachine vendingMachine;

    public WaitToDispenseGoodsState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("UNSUPPORTED OPERATION：已投币，请确认出货");
    }

    @Override
    public void selectGoods() {
        System.out.println("UNSUPPORTED OPERATION：已选择商品，请确认出货");
    }

    @Override
    public void dispense() {
        int leftGoodsNum = vendingMachine.releaseGood();
        if (leftGoodsNum <= 0) {
            vendingMachine.changeState(new SoldOutState(vendingMachine));
        } else {
            vendingMachine.changeState(new WaitToInsertCoinState(vendingMachine));
        }
        System.out.println("商品已出货，请及时取走");
    }
}