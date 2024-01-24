package com.bravo.other.saga.v2.jar;

// 流程中断异常
public class HaltException extends RuntimeException {
    public HaltException() {
    }

    public HaltException(String message) {
        super(message);
    }

    public HaltException(String message, Throwable cause) {
        super(message, cause);
    }
}