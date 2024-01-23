package com.bravo.pattern.state.v3.state;


import com.bravo.pattern.state.v3.VendingMachine;

public class WaitToSelectGoodsState implements VendingState {

    private static final VendingState INSTANCE = new WaitToSelectGoodsState();

    public static VendingState instance() {
        return INSTANCE;
    }

    private WaitToSelectGoodsState() {
    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：已投币，请选择商品");
    }

    @Override
    public void selectGoods(VendingMachine machine) {
        machine.nextState();
        System.out.println("选中XX商品");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：未选择商品，无法出货");
    }
}
