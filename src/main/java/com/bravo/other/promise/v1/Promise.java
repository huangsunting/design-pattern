package com.bravo.other.promise.v1;

import lombok.Getter;

/**
 * 仿写js的Promise，极简版
 * - 不支持链式处理多个任务
 * - 仅支持处理异步任务，传入同步任务会导致结果无法回调
 */
public class Promise {

    /**
     * 结果处理器
     */
    private ResultHandler resultHandler;
    /**
     * 异常信息处理器
     */
    private ErrorHandler errorHandler;
    /**
     * 任务状态
     */
    private State state = State.PENDING;

    /**
     * 构造函数
     * 1.接收任务
     * 2.启动任务
     */
    public Promise(Task task) {
        // 准备 resolve 和 reject 函数
        Resolution resolution = new Resolution() {
            @Override
            public void resolve(Object obj) {
                if (state != State.PENDING) {
                    return;
                }
                state = State.FULFILLED;
                if (resultHandler != null) {
                    resultHandler.accept(obj);
                }
            }
        };
        Rejection rejection = new Rejection() {
            @Override
            public void reject(Object obj) {
                if (state != State.PENDING) {
                    return;
                }
                state = State.REJECTED;
                if (errorHandler != null) {
                    errorHandler.accept(obj);
                }
            }
        };

        try {
            // 启动任务，同时传入 resolve 和 reject ，用于任务结束后通知promise进行下一步处理
            task.start(resolution, rejection);
        } catch (Exception e) {
            rejection.reject(e);
        }
    }

    /**
     * 正常回调
     */
    public Promise then(ResultHandler resultHandler) {
        this.resultHandler = resultHandler;
        // 支持链式调用
        return this;
    }

    /**
     * 异常捕获
     */
    public void catching(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override
    public String toString() {
        return "Promise{" +
                "state=" + state +
                '}';
    }

    // ------ 下面是辅助类 ------

    @Getter
    private enum State {
        PENDING,
        FULFILLED,
        REJECTED;
    }

    public interface Task {
        void start(Resolution r, Rejection rj);
    }

    public interface Resolution {
        void resolve(Object obj);
    }

    public interface Rejection {
        void reject(Object obj);
    }

    public interface ResultHandler {
        void accept(Object result);
    }

    public interface ErrorHandler {
        void accept(Object error);
    }

}