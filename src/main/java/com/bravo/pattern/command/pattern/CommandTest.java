package com.bravo.pattern.command.pattern;

import com.bravo.pattern.command.pattern.command.Command;
import com.bravo.pattern.command.pattern.command.ConcreteCommandA;
import com.bravo.pattern.command.pattern.invoker.Invoker;
import com.bravo.pattern.command.pattern.receiver.ReceiverA;

public class CommandTest {

    public static void main(String[] args) {
        Command command = buildCommand();
        Invoker invoker = new Invoker(command);
        invoker.request();
    }

    /**
     * 如果有多个Receiver，可以通过编写对应的ConcreteCommand来处理
     * 同时Invoker保持稳定，不受影响
     */
    private static Command buildCommand() {
        ReceiverA receiver = new ReceiverA();
        return new ConcreteCommandA(receiver);
    }
}