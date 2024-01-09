package com.bravo.advanced.threadpool;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ThreadPool1 {

    /**
     * 任务队列
     */
    private final BlockingQueue<Runnable> workQueue;
    /**
     * 工作线程
     */
    private final List<Worker> workers = new ArrayList<>();
    /**
     * 线程数
     */
    private final int poolSize;


    /**
     * 构造器
     *
     * @param poolSize  线程数
     * @param workQueue 任务队列
     */
    public ThreadPool1(int poolSize, BlockingQueue<Runnable> workQueue) {
        // 创建线程池。此时不直接初始化线程，execute提交任务时再初始化
        this.workQueue = workQueue;
        this.poolSize = poolSize;
    }

    /**
     * 提交任务
     * - 线程数 < poolSize，创建线程处理任务
     * - 线程数 >= poolSize，新任务进入队列等待执行
     * - 任务队列爆满，触发拒绝策略
     *
     * @param task 待执行任务
     */
    public void execute(Runnable task) {
        if (workers.size() < poolSize) {
            this.addWorker(task); // 新增一个工作线程worker，同时把当前提交的任务委托给它处理
            return;
        }

        boolean enqueued = workQueue.offer(task);
        if (!enqueued) {
            throw new RuntimeException("拒绝策略");
        }
    }

    private void addWorker(Runnable task) {
        // 创建工作线程，加入worker，启动工作线程
        Worker worker = new Worker(task);
        workers.add(worker);
        worker.getThread().start();
    }

    private Runnable getTaskFromQueue() {
        try {
            return workQueue.take();
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Getter
    @Setter
    private class Worker implements Runnable {
        private Thread thread;
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
            thread = new Thread(this); // worker同时是一个Runnable，thread启动后会执行Worker#run，最终执行Worker#task
        }

        @Override
        public void run() {
            // 优先处理worker自带的任务，然后循环从任务队列获取任务
            while (task != null || (task = getTaskFromQueue()) != null) {
                task.run();
                task = null;// 执行完毕，清空任务
            }
        }
    }
}