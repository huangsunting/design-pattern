package com.bravo.pattern.facade.computer;

// 子系统 3：硬盘
public class HardDrive {
    public void read() {
        System.out.println("Hard Drive is reading");
    }

    public void write() {
        System.out.println("Hard Drive is writing");
    }
}