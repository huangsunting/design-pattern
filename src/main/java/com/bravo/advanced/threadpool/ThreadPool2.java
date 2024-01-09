package com.bravo.advanced.threadpool;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPool2 {

    /**
     * 工作线程
     */
    private final List<Worker> workers = new ArrayList<>();
    /**
     * 任务队列
     */
    private final BlockingQueue<Runnable> workQueue;
    /**
     * 核心线程数
     */
    private final int corePoolSize;
    /**
     * 最大线程数
     */
    private final int maximumPoolSize;
    /**
     * 非核心线程最大空闲时间（否则销毁线程）
     */
    private final long keepAliveTime;

    public ThreadPool2(int corePoolSize,
                       int maximumPoolSize,
                       long keepAliveTime,
                       TimeUnit timeUnit,
                       BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = timeUnit.toNanos(keepAliveTime);
    }

    /**
     * 提交任务
     * - 线程数 < corePoolSize，创建线程处理任务（核心线程）
     * - 线程数 >= corePoolSize，新任务进入队列等待执行
     * - 任务队列爆满，继续创建线程处理任务（非核心线程）
     * - 线程数 >= maximumPoolSize，触发拒绝策略
     *
     * @param task 待执行任务
     */
    public void execute(Runnable task) {
        Assert.notNull(task, "task is null");

        if (workers.size() < corePoolSize) {
            this.addWorker(task, true); // core=true，创建核心线程
            return;
        }

        boolean enqueued = workQueue.offer(task);
        if (enqueued) {
            return;
        }

        if (!this.addWorker(task, false)) { // core=false，创建非核心线程
            throw new RuntimeException("拒绝策略"); 
        }
    }

    private boolean addWorker(Runnable task, boolean core) {
        int wc = workers.size();
        if (wc >= (core ? corePoolSize : maximumPoolSize)) {
            return false;
        }

        Worker worker = new Worker(task);
        workers.add(worker);
        worker.getThread().start();
        return true;
    }

    private Runnable getTaskFromQueue() {
        boolean timedOut = false;

        // 循环获取任务
        for (; ; ) {

            // 池中线程数超过corePoolSize，尝试销毁一部分线程
            boolean tryDestroy = workers.size() > corePoolSize;

            // 尝试销毁线程 && 已经超时了
            if (tryDestroy && timedOut) {
                return null;
            }

            try {
                // 尝试销毁超出corePoolSize的线程？
                // 1.需要：poll定时阻塞，等到超时就返回null
                // 2.不需要：take持续阻塞，直到获取结果
                Runnable r = tryDestroy ?
                        workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) :
                        workQueue.take();
                if (r != null)
                    return r;
                timedOut = true;
            } catch (InterruptedException retry) {
                timedOut = false;
            }
        }
    }

    @Getter
    @Setter
    private class Worker implements Runnable {
        private Thread thread;
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
            thread = new Thread(this);
        }

        @Override
        public void run() {
            try {
                // 循环处理任务
                while (task != null || (task = getTaskFromQueue()) != null) {
                    task.run();
                    task = null;
                }
            } finally {
                // 程序走到这，说明 线程空闲 && 池中线程数>corePoolSize                
                System.out.println(thread.getName() + "被销毁");               
                // 移除thread对象，方便gc回收。实际的线程资源执行完当前方法后就结束了     
                workers.remove(this);
            }        
        }
    }
}