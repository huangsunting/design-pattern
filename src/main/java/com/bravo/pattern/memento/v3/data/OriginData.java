package com.bravo.pattern.memento.v3.data;

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

    public Snapshot snapshot() {
        return new Snapshot(data1, data2, data3);
    }
    
    public void rollback(ISnapshot iSnapshot) {
        if (iSnapshot instanceof Snapshot) {
            // 恢复数据
            Snapshot snapshot = (Snapshot) iSnapshot;
            data1 = snapshot.getData1(); // 强转为Snapshot就有getter方法了
            data2 = snapshot.getData2();
            data3 = snapshot.getData3();
        } else {
            throw new RuntimeException("OriginData快照类型错误");
        }
    }
}