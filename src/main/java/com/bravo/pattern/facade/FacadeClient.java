package com.bravo.pattern.facade;

import com.bravo.pattern.facade.facade.ComputerFacade;

public class FacadeClient {
    public static void main(String[] args) {
        // 使用 Facade 启动和关闭电脑
        ComputerFacade computer = new ComputerFacade();
        computer.start();
        System.out.println("---------");
        computer.shutdown();
    }
}