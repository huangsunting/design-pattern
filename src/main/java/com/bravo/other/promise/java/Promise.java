package com.bravo.other.promise.java;

import lombok.Getter;

/**
 * 仿写js的Promise，极简版
 * - 不支持链式处理多个任务
 * - 不支持异常回调，异常结果无法回调
 * - 不支持同步任务，执行结果无法回调
 * 要想支持上面两个功能，特别是链式调用（包括resolve和reject的正确触发then和catching），需要花很大功夫。
 * 当前这个案例想要告诉大家的是：对于异步结果的获取，回调是一种很不错的选择。
 * 比如开启任务前，传入resolve和reject，结束后由任务触发回调。相当于临别前我给你一个手机，想我了就用这个手机把这个讯息传递给我！
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