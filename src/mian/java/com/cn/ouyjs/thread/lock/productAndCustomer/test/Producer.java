package com.cn.ouyjs.thread.lock.productAndCustomer.test;

/**
 * @author ouyjs
 * @date 2019/8/9 11:32
 */
public class Producer implements Runnable {
    private ProducerAndCustomer producerAndCustomer;

    public Producer(ProducerAndCustomer producerAndCustomer) {
        this.producerAndCustomer = producerAndCustomer;
    }

    @Override
    public void run() {
        while (true) {
            producerAndCustomer.push();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
