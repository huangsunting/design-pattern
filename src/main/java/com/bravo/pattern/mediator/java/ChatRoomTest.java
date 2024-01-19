package com.bravo.pattern.mediator.java;

import com.bravo.pattern.mediator.java.colleague.ConcreteUser;
import com.bravo.pattern.mediator.java.mediator.ChatRoomMediator;

public class ChatRoomTest {
    public static void main(String[] args) {
        ChatRoomMediator mediator = new ChatRoomMediator();
        // 多个控件
        ConcreteUser user1 = new ConcreteUser("张三", mediator);
        ConcreteUser user2 = new ConcreteUser("李四", mediator);
        ConcreteUser user3 = new ConcreteUser("王五", mediator);

        // 底层通过mediator交互
        user1.sendMessage("你好！");
        user2.sendMessage("你好！");
        user3.sendMessage("你好！");

        mediator.removeUser(user1);
        user1.sendMessage("我还在群里吗");
    }
}