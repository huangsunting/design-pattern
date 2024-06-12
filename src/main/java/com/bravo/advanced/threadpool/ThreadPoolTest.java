package com.bravo.advanced.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // SimpleThreadPool threadPool = new SimpleThreadPool(1, new ArrayBlockingQueue<>(2));
        // ThreadPool1 threadPool = new ThreadPool1(1, new ArrayBlockingQueue<>(2));
        // ThreadPool2 threadPool = new ThreadPool2(1, 3, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
        ThreadPool3 threadPool = new ThreadPool3(1, 3, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

        for (int i = 1; i <= 4; i++) {
            int index = i;
            System.out.println("提交任务" + index + "START");
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "：任务" + index + "开始");
                    sleep(3);
                    System.out.println(Thread.currentThread().getName() + "：任务" + index + "结束");
                }
            });
            System.out.println("提交任务" + index + "END");
        }

        sleep(100);
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println("sleep exception");
        }
    }
}