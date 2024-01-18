package com.bravo.pattern.facade;

import com.bravo.pattern.facade.computer.CPU;
import com.bravo.pattern.facade.computer.HardDrive;
import com.bravo.pattern.facade.computer.Memory;

public class NormalClient {
    public static void main(String[] args) {
        CPU cpu = new CPU();
    	Memory memory = new Memory();
    	HardDrive hardDrive = new HardDrive();

        // 启动电脑
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Computer is started");

        // 使用电脑...
        System.out.println("---------");

        // 关闭电脑
        cpu.shutdown();
        memory.unload();
        hardDrive.write();
        System.out.println("Computer is shut down");
    }
}