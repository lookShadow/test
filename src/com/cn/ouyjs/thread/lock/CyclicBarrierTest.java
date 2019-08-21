package com.cn.ouyjs.thread.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author ouyjs
 * @date 2019/8/19 9:31
 */
public class CyclicBarrierTest {


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
            for (int i =0;i<12; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println(Thread.currentThread().getName()+" 进来");
                            try {
                                cyclicBarrier.await(2L, TimeUnit.SECONDS);
                            } catch (TimeoutException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName()+" 出去");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
    }
}

