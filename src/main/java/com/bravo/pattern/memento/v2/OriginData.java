package com.bravo.pattern.memento.v2;

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


    // 创建快照
    public Snapshot snapshot() {
        return new Snapshot(data1, data2, data3);
    }

    // 读取快照
    public void rollback(Snapshot snapshot) {
        // 恢复数据
        data1 = snapshot.data1;
        data2 = snapshot.data2;
        data3 = snapshot.data3;
    }

    // 静态内部类：得益于内部类的特性，这里可以用更严格private（反正不影响外部类OriginData访问Snapshot）
    public static class Snapshot {
        private final String data1;
        private final String data2;
        private final String data3;

        private Snapshot(String data1, String data2, String data3) {
            this.data1 = data1;
            this.data2 = data2;
            this.data3 = data3;
        }
    }
}