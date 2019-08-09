package com.cn.ouyjs.thread.lock.productAndCustomer.test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ouyjs
 * @date 2019/8/9 11:32
 */
public class ProducerAndCustomer {
    private int count;
    public final int MAX_COUNT = 10;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition push = reentrantLock.newCondition();
    Condition take = reentrantLock.newCondition();

    public void push() {
        try {
            reentrantLock.lock();
            while (count >= 10) {
                System.out.println("库存大于等于10个，阻塞停止生产！");
                try {
                    push.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "生产者生产，库存：" + count);
            take.signal();
        }finally {
            reentrantLock.unlock();
        }
    }

    public void take() {

       try {
           reentrantLock.lock();
           while (count <= 0) {
               System.out.println("拿的太快啦，收手停止一下啦！");
               try {
                   take.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           count--;
           System.out.println("有人偷偷拿走一个商品，还剩:" + count);
           push.signal();
       }finally {
           reentrantLock.unlock();
       }

    }


    public static void main(String[] args) {

        ProducerAndCustomer producerAndCustomer = new ProducerAndCustomer();

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        executorService.execute(new Producer(producerAndCustomer));
        executorService.execute(new Producer(producerAndCustomer));
        executorService.execute(new Producer(producerAndCustomer));
        executorService.execute(new Producer(producerAndCustomer));


        executorService.execute(new Customer(producerAndCustomer));
    /*    executorService.execute(new Customer(producerAndCustomer));
        executorService.execute(new Customer(producerAndCustomer));
        executorService.execute(new Customer(producerAndCustomer));
        executorService.execute(new Customer(producerAndCustomer));
        executorService.execute(new Customer(producerAndCustomer));*/


    }

}
