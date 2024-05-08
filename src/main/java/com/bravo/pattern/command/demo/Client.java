package com.bravo.pattern.command.demo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        // 向Server发送请求（这里没有Receiver，直接把逻辑写在Command）
        try (Socket s = new Socket("127.0.0.1", 8080)) {
            Server.Command command = (a, b) -> a + b + 10;
            ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
            os.writeObject(command);
            os.flush();
        }
    }

}