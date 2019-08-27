package com.cn.ouyjs.thread.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author ouyjs
 * @date 2019/8/8 16:37
 */
public class MyThread implements Runnable {
    CountDownLatch countDownLatch;

    MyThread( CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000 +(long)(Math.random()*1000+1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("class:"+this.getClass()+"-----thread name:" +Thread.currentThread().getName() + "---time:"+System.currentTimeMillis());
    }
}
