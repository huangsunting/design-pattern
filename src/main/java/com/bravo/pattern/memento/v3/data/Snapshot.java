package com.bravo.pattern.memento.v3.data;

import lombok.Getter;

// 外部无法引用类、无法创建对象
@Getter
class Snapshot implements ISnapshot {
    private final String data1;
    private final String data2;
    private final String data3;

    Snapshot(String data1, String data2, String data3) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }
}