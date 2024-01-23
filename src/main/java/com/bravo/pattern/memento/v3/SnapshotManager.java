package com.bravo.pattern.memento.v3;

import com.bravo.pattern.memento.v3.data.ISnapshot;

import java.util.ArrayList;
import java.util.List;

public class SnapshotManager {
    private final List<ISnapshot> snapshotList = new ArrayList<>();

    public void add(ISnapshot snapshot) {
        snapshotList.add(snapshot);
    }

    // 接口没有方法，对外部是黑盒
    public ISnapshot get(int index) {
        // Snapshot snapshot = new Snapshot("", "", ""); 无法访问Snapshot类
        return snapshotList.get(index);
    }

}