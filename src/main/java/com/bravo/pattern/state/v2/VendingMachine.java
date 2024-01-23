package com.bravo.pattern.state.v2;

import com.bravo.pattern.state.v2.state.SoldOutState;
import com.bravo.pattern.state.v2.state.VendingState;
import com.bravo.pattern.state.v2.state.WaitToDispenseGoodsState;
import com.bravo.pattern.state.v2.state.WaitToInsertCoinState;
import com.bravo.pattern.state.v2.state.WaitToSelectGoodsState;

/**
 * state pattern version2：Machine负责切换状态
 */
public class VendingMachine {
    // 商品数量
    private int goodsNum;
    // 售货机当前状态
    private VendingState currentState;

    public VendingMachine(int goodsNum) {
        this.goodsNum = goodsNum;
        if (this.goodsNum <= 0) {
            this.currentState = new SoldOutState(this);
        } else {
            this.currentState = new WaitToInsertCoinState(this);
        }
    }

    public void insertCoin() {
        this.currentState.insertCoin();
    }

    public void selectGoods() {
        this.currentState.selectGoods();
    }

    public void dispense() {
        this.currentState.dispense();
    }

    public void releaseGood() {
        goodsNum -= 1;
    }

    /**
     * machine统一管理状态切换
     */
    public void nextState() {
        if (this.currentState instanceof WaitToInsertCoinState) {
            this.currentState = new WaitToSelectGoodsState(this);
        } else if (this.currentState instanceof WaitToSelectGoodsState) {
            this.currentState = new WaitToDispenseGoodsState(this);
        } else if (this.currentState instanceof WaitToDispenseGoodsState) {
            if (goodsNum <= 0) {
                this.currentState = new SoldOutState(this);
            } else {
                this.currentState = new WaitToInsertCoinState(this);
            }
        } else {
            throw new RuntimeException("未知状态，请联系客服");
        }
    }
}