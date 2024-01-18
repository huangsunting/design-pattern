package com.bravo.pattern.facade.computer;

// 子系统 1：CPU
public class CPU {
    public void start() {
        System.out.println("CPU is starting");
    }

    public void shutdown() {
        System.out.println("CPU is shutting down");
    }
}
