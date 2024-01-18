package com.bravo.pattern.facade.facade;

import com.bravo.pattern.facade.computer.CPU;
import com.bravo.pattern.facade.computer.HardDrive;
import com.bravo.pattern.facade.computer.Memory;

public class ComputerFacade {
    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    // 启动电脑
    public void start() {
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Computer is started");
    }

    // 关闭电脑
    public void shutdown() {
        cpu.shutdown();
        memory.unload();
        hardDrive.write();
        System.out.println("Computer is shut down");
    }
}