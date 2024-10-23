package com.bravo.other.promise;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
public class PromiseTest {

    /**
     * 模拟js的Promise，resolve场景
     */
    @Test
    public void testAsyncTaskResolved() throws InterruptedException {
        Promise p = new Promise((r, rj) -> {
            setTimeout(() -> {
                r.resolve("success");
            }, 2000);
        });

        log.info("promise:{}", p);

        p.then(result -> {
            log.info("异步操作执行结果:{}", result);
        }).catching(error -> {
            log.info("异步操作执行结果:{}", error);
        });

        log.info("promise:{}", p);

        // 等待异步执行完毕，重新观察promise的状态
        TimeUnit.SECONDS.sleep(5);
        log.info("promise:{}", p);
    }

    /**
     * 模拟js的Promise，reject场景
     */
    @Test
    public void testAsyncTaskRejected() throws InterruptedException {
        new Promise((r, rj) -> {
            setTimeout(() -> {
                rj.reject("error");
            }, 2000);
        }).then(result -> {
            log.info("异步操作执行结果:{}", result);
        }).catching(error -> {
            log.info("异步操作执行结果:{}", error);
        });

        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * 由于这里是另一个线程里的异常，当前线程无法捕获，所以catching逻辑
     */
    @Test
    public void testAsyncTaskException() throws InterruptedException {
        new Promise((r, rj) -> {
            setTimeout(() -> {
                throw new RuntimeException("runtime exception...");
            }, 1000);
        }).then(result -> {
            log.info("异步操作执行结果:{}", result);
        }).catching(error -> {
            log.info("异步操作执行结果:{}", error);
        });

        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * BUG：如果构造函数传入的是同步任务，会立即执行then或catch，而此时then还没设置，会有问题
     */
    @Test
    public void testSyncTask() {
        Promise p = new Promise((r, rj) -> {
            r.resolve("success");
            rj.reject("error");
        });

        log.info("promise:{}", p);

        p.then(result -> {
            log.info("同步操作执行结果:{}", result);
        }).catching(error -> {
            log.info("同步操作执行结果:{}", error);
        });

        log.info("promise:{}", p);
    }

    /**
     * 模拟js的setTimeout函数
     */
    private static void setTimeout(Runnable runnable, long delay) {
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
                runnable.run();
            } catch (InterruptedException e) {
                log.info("InterruptedException");
            }
        }).start();
    }

}
