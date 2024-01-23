package com.bravo.pattern.state.v3.state;


import com.bravo.pattern.state.v3.VendingMachine;

public class WaitToDispenseGoodsState implements VendingState {

    private static final VendingState INSTANCE = new WaitToDispenseGoodsState();

    public static VendingState instance() {
        return INSTANCE;
    }

    private WaitToDispenseGoodsState() {
    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：已投币，请确认出货");
    }

    @Override
    public void selectGoods(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：已选择商品，请确认出货");
    }

    @Override
    public void dispense(VendingMachine machine) {
        machine.releaseGood();
        machine.nextState();
        System.out.println("商品已出货，请及时取走");
    }
}
