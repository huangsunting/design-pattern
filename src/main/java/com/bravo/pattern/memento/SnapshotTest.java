package com.bravo.pattern.memento;

//import com.bravo.pattern.memento.v3.data.OriginData;
//import com.bravo.pattern.memento.v3.SnapshotManager;

import com.bravo.pattern.memento.v2.OriginData;
import com.bravo.pattern.memento.v2.SnapshotManager;

public class SnapshotTest {
    public static void main(String[] args) {
        // 初始化OriginData、SnapshotManager
        OriginData originData = new OriginData("内容01", "内容02", "内容03");
        SnapshotManager snapshotManager = new SnapshotManager();

        // 修改对象：版本1
        originData.setData1("内容11");
        originData.setData2("内容12");
        snapshotManager.add(originData.snapshot());

         // 修改对象：版本2
        originData.setData1("内容21");
        originData.setData2("内容22");
        snapshotManager.add(originData.snapshot());

         // 修改对象：版本3
        originData.setData1("内容31");
        originData.setData2("内容32");
        snapshotManager.add(originData.snapshot());

        // 快照不可修改
        // snapshotManager.get(0).setData1("快照被修改啦");
        // 外部无法创建快照
        // OriginData.Snapshot snapshot = new OriginData.Snapshot("", "", "");

        // 恢复快照到版本1
        System.out.println("当前状态： " + originData);
        originData.rollback(snapshotManager.get(0));
        System.out.println("恢复到快照1: " + originData);
    }
}