package com.bravo.pattern.state.v1;

import com.bravo.pattern.state.v1.state.SoldOutState;
import com.bravo.pattern.state.v1.state.VendingState;
import com.bravo.pattern.state.v1.state.WaitToInsertCoinState;

/**
 * state pattern version1：各个State自己负责切换状态
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

    /********* START：对machine的操作直接委托给state *********/
    public void insertCoin() {
        this.currentState.insertCoin();
    }

    public void selectGoods() {
        this.currentState.selectGoods();
    }

    public void dispense() {
        this.currentState.dispense();
    }
    /********* END：对machine的操作直接委托给state *********/
    
    public int releaseGood() {
        // 返回剩余数量
        return goodsNum -= 1;
    }

    public void changeState(VendingState newState) {
        this.currentState = newState;
    }
}