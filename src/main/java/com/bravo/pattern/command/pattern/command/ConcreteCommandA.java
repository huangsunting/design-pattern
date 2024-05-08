package com.bravo.pattern.command.pattern.command;


import com.bravo.pattern.command.pattern.receiver.ReceiverA;

public class ConcreteCommandA implements Command {

    private final ReceiverA receiver;

    public ConcreteCommandA(ReceiverA receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.receiverMethod();
    }
}
