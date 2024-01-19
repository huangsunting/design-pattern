package com.bravo.pattern.mediator.java.colleague;

import com.bravo.pattern.mediator.java.mediator.ChatRoomMediator;

public class ConcreteUser implements User {
    private final String name;
    private final ChatRoomMediator mediator;

    public ConcreteUser(String name, ChatRoomMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addUser(this);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + "发送给聊天室： " + message);
        mediator.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + "收到来自聊天室的消息： " + message);
    }

    @Override
    public String toString() {
        return name;
    }
}