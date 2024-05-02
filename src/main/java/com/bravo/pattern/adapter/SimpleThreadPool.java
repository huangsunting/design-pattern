package com.bravo.pattern.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * 适配器模式很简单，重点看一下{@link java.util.concurrent.Executors#callable(Runnable, Object)}
 * 通过RunnableAdapter将Runnable类型的任务转为Callable类型
 * 属于对象适配器（组合）
 */
public class SimpleThreadPool {

    private final BlockingQueue<Runnable> workQueue;

    private final List<Worker> workers = new ArrayList<>();

    public SimpleThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        // 创建线程，并加入线程池
        for (int i = 0; i < poolSize; i++) {
            Worker work = new Worker();
            work.start();
            workers.add(work);
        }
    }

    // 核心方法：执行Runnable任务
    public void execute(Runnable command) {
        try {
            workQueue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 辅助方法
    public Future<?> submit(Runnable task) {
        return submit(task, null);
    }

    // 辅助方法
    public <T> Future<T> submit(Runnable task, T result) {
        if (task == null) throw new NullPointerException();
        // 将Runnable包装成FutureTask，交给execute执行，同时把FutureTask返回给客户程序，方便外部阻塞获取结果
        RunnableFuture<T> future = new FutureTask<T>(task, result);
        execute(future);
        return future;
    }

    // 辅助方法
    public <T> Future<T> submit(Callable<T> task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<T> future = new FutureTask<>(task);
        execute(future);
        return future;
    }

    private class Worker extends Thread {
        public void run() {
            while (true) {
                try {
                    Runnable task = workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}