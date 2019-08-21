package com.cn.ouyjs.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ouyjs
 * @date 2019/8/8 16:36
 *
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        threadPool.execute(new MyThread(countDownLatch));
        threadPool.execute(new MyThread(countDownLatch));
        threadPool.execute(new MyThread(countDownLatch));
        threadPool.execute(new MyThread(countDownLatch));
        threadPool.execute(new MyThread(countDownLatch));
        threadPool.execute(new MyThread(countDownLatch));
    }
}
