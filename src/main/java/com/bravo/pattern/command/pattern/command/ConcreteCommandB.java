package com.bravo.pattern.command.pattern.command;


import com.bravo.pattern.command.pattern.receiver.ReceiverB;

public class ConcreteCommandB implements Command {

    private final ReceiverB receiver;

    public ConcreteCommandB(ReceiverB receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.receiverMethod();
    }
}
