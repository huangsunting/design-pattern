package com.bravo.pattern.memento.v1.data;

public class Snapshot { // 1.【类】公共权限，外部能访问（依赖）
    final String data1; // 2.【字段】包访问权限
    final String data2;
    final String data3;

    Snapshot(String data1, String data2, String data3) { // 3.【构造函数】包访问权限
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    String getData1() { // 4.【方法】包访问权限
        return data1;
    }

    String getData2() {
        return data2;
    }

    String getData3() {
        return data3;
    }
}