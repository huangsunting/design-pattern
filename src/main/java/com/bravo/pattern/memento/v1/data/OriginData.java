package com.bravo.pattern.memento.v1.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class OriginData {
    @Getter
    @Setter
    private String data1;
    @Getter
    @Setter
    private String data2;
    // 不对外暴露
    private String data3;

    // 1.创建Snapshot类型的快照（之前返回的是OriginData）
    public Snapshot snapshot() {
        return new Snapshot(data1, data2, data3);
    }

    // 2.接收Snapshot快照并回复对象状态
    public void rollback(Snapshot snapshot) {
        // 恢复数据
        data1 = snapshot.getData1();
        data2 = snapshot.getData2();
        data3 = snapshot.getData3();
    }
}