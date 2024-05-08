package com.bravo.pattern.command.demo;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Server {

    /**
     * Server定义Command接口，而Client负责具体实现
     */
    public interface Command extends Serializable {
        int calculate(int a, int b);
    }

    /**
     * Server持续监听Client传递的Command并在Server端执行Command，此时Command即行为参数化
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("server start...");

        ExecutorService executor = Executors.newFixedThreadPool(10);

        while (true) {
            Socket s = ss.accept();
            executor.submit(() -> {
                try (ObjectInputStream is = new ObjectInputStream(s.getInputStream())) {
                    Command command = (Command) is.readObject();
                    int a = queryDataFromDB();
                    int b = queryDataFromDB();
                    log.info("client:{}, a:{}, b:{}, result:{}", s.getRemoteSocketAddress().toString(), a, b, command.calculate(a, b));
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private static int queryDataFromDB() {
        return ThreadLocalRandom.current().nextInt(10);
    }
}