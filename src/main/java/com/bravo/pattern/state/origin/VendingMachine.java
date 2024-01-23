package com.bravo.pattern.state.origin;

import static com.bravo.pattern.state.origin.VendingStateEnum.SOLD_OUT;
import static com.bravo.pattern.state.origin.VendingStateEnum.WAIT_TO_DISPENSE_GOODS;
import static com.bravo.pattern.state.origin.VendingStateEnum.WAIT_TO_INSERT_COIN;
import static com.bravo.pattern.state.origin.VendingStateEnum.WAIT_TO_SELECT_GOODS;

/**
 * 售货机
 */
public class VendingMachine {
    // 商品数量
    private int goodsNum;
    // 售货机当前状态
    private VendingStateEnum currentState;

    public VendingMachine(int goodsNum) {
        this.goodsNum = goodsNum;
        if (this.goodsNum <= 0) {
            currentState = SOLD_OUT; // 静态导入，等同VendingStateEnum.SOLD_OUT
        } else {
            currentState = WAIT_TO_INSERT_COIN;
        }
    }

    /**
     * 投币
     */
    public void insertCoin() {
        if (currentState == SOLD_OUT) {
            System.out.println("UNSUPPORTED OPERATION：商品已售罄");
        } else if (currentState == WAIT_TO_INSERT_COIN) {
            currentState = WAIT_TO_SELECT_GOODS;
            System.out.println("投币成功，请选择商品");
        } else if (currentState == WAIT_TO_SELECT_GOODS) {
            System.out.println("UNSUPPORTED OPERATION：已投币，请选择商品");
        } else if (currentState == WAIT_TO_DISPENSE_GOODS) {
            System.out.println("UNSUPPORTED OPERATION：已投币，请确认出货");
        } else {
            throw new RuntimeException("未知状态，请联系客服");
        }
    }

    /**
     * 选择商品
     */
    public void selectGoods() {
        if (currentState == SOLD_OUT) {
            System.out.println("UNSUPPORTED OPERATION：商品已售罄");
        } else if (currentState == WAIT_TO_INSERT_COIN) {
            System.out.println("UNSUPPORTED OPERATION：请先投币");
        } else if (currentState == WAIT_TO_SELECT_GOODS) {
            currentState = WAIT_TO_DISPENSE_GOODS;
            System.out.println("选中XX商品");
        } else if (currentState == WAIT_TO_DISPENSE_GOODS) {
            System.out.println("UNSUPPORTED OPERATION：已选择商品，请确认出货");
        } else {
            throw new RuntimeException("未知状态，请联系客服");
        }
    }

    /**
     * 出货
     */
    public void dispense() {
        if (currentState == SOLD_OUT) {
            System.out.println("UNSUPPORTED OPERATION：商品已售罄");
        } else if (currentState == WAIT_TO_INSERT_COIN) {
            System.out.println("UNSUPPORTED OPERATION：请先投币");
        } else if (currentState == WAIT_TO_SELECT_GOODS) {
            System.out.println("UNSUPPORTED OPERATION：未选择商品，无法出货");
        } else if (currentState == WAIT_TO_DISPENSE_GOODS) {
            goodsNum = goodsNum - 1;
            if (goodsNum <= 0) {
                currentState = SOLD_OUT;
            } else {
                currentState = WAIT_TO_INSERT_COIN;
            }
            System.out.println("商品已出货，请及时取走");
        } else {
            throw new RuntimeException("未知状态，请联系客服");
        }
    }
}