package com.bravo.pattern.facade.computer;

// 子系统 2：内存
public class Memory {
    public void load() {
        System.out.println("Memory is loading");
    }

    public void unload() {
        System.out.println("Memory is unloading");
    }
}