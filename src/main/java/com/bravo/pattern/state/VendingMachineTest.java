package com.bravo.pattern.state;

//import com.bravo.pattern.state.origin.VendingMachine;

//import com.bravo.pattern.state.v1.VendingMachine;

//import com.bravo.pattern.state.v2.VendingMachine;

import com.bravo.pattern.state.v3.VendingMachine;

public class VendingMachineTest {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(2);
        vendingMachine.selectGoods();  // UNSUPPORTED OPERATION：请先投币
        vendingMachine.insertCoin();   // 投币成功，请选择商品
        vendingMachine.dispense();     // UNSUPPORTED OPERATION：未选择商品，无法出货
        System.out.println("===================");
        vendingMachine.selectGoods();  // 选中XX商品
        vendingMachine.insertCoin();   // UNSUPPORTED OPERATION：已投币，请确认出货
        vendingMachine.dispense();     // 商品已出货，请及时取走
        System.out.println("===================");
        vendingMachine.insertCoin();   // 投币成功，请选择商品
        vendingMachine.selectGoods();  // 选中XX商品
        vendingMachine.dispense();     // 商品已出货，请及时取走
        System.out.println("===================");
        vendingMachine.insertCoin();   // UNSUPPORTED OPERATION：商品已售罄
        vendingMachine.selectGoods();  // UNSUPPORTED OPERATION：商品已售罄
        vendingMachine.dispense();     // UNSUPPORTED OPERATION：商品已售罄
    }
}