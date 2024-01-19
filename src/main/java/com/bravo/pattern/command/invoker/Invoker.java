package com.bravo.pattern.command.invoker;

import com.bravo.pattern.command.command.Command;

public class Invoker {

    private final Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void request() {
        if (command != null) {
            command.execute();
        }
    }

    public void start() {
        request();
    }
}