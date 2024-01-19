package com.bravo.pattern.mediator.java.mediator;

import com.bravo.pattern.mediator.java.colleague.User;

public interface Mediator {
    void sendMessage(User sender, String message);
}