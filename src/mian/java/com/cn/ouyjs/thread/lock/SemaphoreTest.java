package com.cn.ouyjs.thread.lock;

import java.util.concurrent.Semaphore;

/**
 * @author ouyjs
 * @date 2019/8/8 16:57
 * 信号量测试
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i <10;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println( "还有多少信号量"+semaphore.availablePermits());
                    System.out.println("thread name:" +Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                }
            }).start();
        }
    }
}
