package com.cn.ouyjs.thread.redis;

/**
 * @author ouyjs
 * @date 2019/7/29 9:17
 */
public class TestThread implements Runnable {
    int count;
    TestThread(int count) {
        this.count = count;
    }
    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println(Thread.currentThread().getName() + ":" + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
