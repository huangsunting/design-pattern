package com.bravo.pattern.memento.v2;

import java.util.ArrayList;
import java.util.List;

public class SnapshotManager {
    // 为了支持备份多个快照，这里用List，客户程序可以通过get(index)访问指定快照
    private final List<OriginData.Snapshot> snapshotList = new ArrayList<>();

    public void add(OriginData.Snapshot snapshot) {
        snapshotList.add(snapshot);
    }

    public OriginData.Snapshot get(int index) {
        // OriginData.Snapshot snapshot = new OriginData.Snapshot("", "", ""); // 无法访问构造函数
        return snapshotList.get(index);
    }
}