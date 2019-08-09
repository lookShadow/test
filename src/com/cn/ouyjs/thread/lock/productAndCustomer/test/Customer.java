package com.cn.ouyjs.thread.lock.productAndCustomer.test;

/**
 * @author ouyjs
 * @date 2019/8/9 11:33
 */
public class Customer implements Runnable {
    private ProducerAndCustomer producerAndCustomer;

    public Customer(ProducerAndCustomer producerAndCustomer) {
        this.producerAndCustomer = producerAndCustomer;
    }

    @Override
    public void run() {
        while (true) {
            producerAndCustomer.take();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
