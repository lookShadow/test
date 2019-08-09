package com.cn.ouyjs.thread.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author ouyjs
 * @date 2019/8/8 16:36
 *
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i< 10 ; i++) {
            new Thread(new MyThread(countDownLatch)).start();
            countDownLatch.countDown();
        }
    }
}
