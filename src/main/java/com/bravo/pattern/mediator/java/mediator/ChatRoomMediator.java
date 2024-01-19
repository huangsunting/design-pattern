package com.bravo.pattern.mediator.java.mediator;


import com.bravo.pattern.mediator.java.colleague.User;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomMediator implements Mediator {
    private final List<User> users;

    public ChatRoomMediator() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        System.out.println("移除用户：[" + user + "]");
        users.remove(user);
    }

    @Override
    public void sendMessage(User sender, String message) {
        if (!users.contains(sender)) {
            throw new RuntimeException("您已被移出该群");
        }
        for (User user : users) {
            if (!user.equals(sender)) {
                user.receiveMessage(message);
            }
        }
        System.out.println("--------------------------");
    }
}
