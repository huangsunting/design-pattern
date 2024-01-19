package com.bravo.pattern.adapter;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SimpleThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SimpleThreadPool simpleThreadPool = new SimpleThreadPool(2, new ArrayBlockingQueue<Runnable>(10));
        Future<String> task = simpleThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Callable over");
                return "Hello World";
            }
        });

        System.out.println("准备获取结果");
        Object result = task.get();
        System.out.println("获取到结果：" + JSON.toJSONString(result));
    }
}