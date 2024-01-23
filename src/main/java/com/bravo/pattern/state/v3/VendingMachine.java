package com.bravo.pattern.state.v3;

import com.bravo.pattern.state.v3.state.SoldOutState;
import com.bravo.pattern.state.v3.state.VendingState;
import com.bravo.pattern.state.v3.state.WaitToDispenseGoodsState;
import com.bravo.pattern.state.v3.state.WaitToInsertCoinState;
import com.bravo.pattern.state.v3.state.WaitToSelectGoodsState;

/**
 * state pattern version3：具体State如果没有成员变量，可以使用单例模式
 */
public class VendingMachine {
    // 商品数量
    private int goodsNum;
    // 售货机当前状态
    private VendingState currentState;

    public VendingMachine(int goodsNum) {
        this.goodsNum = goodsNum;
        if (this.goodsNum <= 0) {
            this.currentState = SoldOutState.instance();
        } else {
            this.currentState = WaitToInsertCoinState.instance();
        }
    }

    /**
     * 投币
     */
    public void insertCoin() {
        this.currentState.insertCoin(this);
    }

    /**
     * 选择商品
     */
    public void selectGoods() {
        this.currentState.selectGoods(this);
    }

    /**
     * 出货
     */
    public void dispense() {
        this.currentState.dispense(this);
    }

    public void releaseGood() {
        goodsNum -= 1;
    }

    public void nextState() {
        if (this.currentState instanceof WaitToInsertCoinState) {
            this.currentState = WaitToSelectGoodsState.instance();
        } else if (this.currentState instanceof WaitToSelectGoodsState) {
            this.currentState = WaitToDispenseGoodsState.instance();
        } else if (this.currentState instanceof WaitToDispenseGoodsState) {
            if (goodsNum <= 0) {
                this.currentState = SoldOutState.instance();
            } else {
                this.currentState = WaitToInsertCoinState.instance();
            }
        } else {
            throw new RuntimeException("未知状态，请联系客服");
        }
    }
}