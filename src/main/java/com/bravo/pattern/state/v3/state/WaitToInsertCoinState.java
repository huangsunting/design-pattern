package com.bravo.pattern.state.v3.state;


import com.bravo.pattern.state.v3.VendingMachine;

public class WaitToInsertCoinState implements VendingState {

    private static final VendingState INSTANCE = new WaitToInsertCoinState();

    public static VendingState instance() {
        return INSTANCE;
    }

    private WaitToInsertCoinState() {
    }

    @Override
    public void insertCoin(VendingMachine machine) {
        machine.nextState();
        System.out.println("投币成功，请选择商品");
    }

    @Override
    public void selectGoods(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：请先投币");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：请先投币");
    }
}
