package com.bravo.pattern.memento.v1;

import com.bravo.pattern.memento.v1.data.OriginData;

import java.util.ArrayList;
import java.util.List;

public class SnapshotManager {
    // 为了支持备份多个快照，这里用List，客户程序可以通过get(index)访问指定快照
    private final List<OriginData> snapshotList = new ArrayList<>();

    public void add(OriginData snapshot) {
        snapshotList.add(snapshot);
    }

    public OriginData get(int index) {
        // Snapshot snapshot = new Snapshot(); // 无法访问构造函数
        return snapshotList.get(index);
    }
}