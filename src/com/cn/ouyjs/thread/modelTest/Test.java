package com.cn.ouyjs.thread.modelTest;

/**
 * @author ouyjs
 * @date 2019/7/4 10:54
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods();
        ProducerTest producer1 = new ProducerTest(goods);
        //ProducerTest producer2 = new ProducerTest(goods);
        //ProducerTest producer3 = new ProducerTest(goods);
        ConsumerTest consumer1 = new ConsumerTest(goods);
        ConsumerTest consumer2 = new ConsumerTest(goods);
        ConsumerTest consumer3 = new ConsumerTest(goods);

        producer1.start();
        //producer2.start();
        //producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();

        producer1.join();
        //producer2.join();
        //producer3.join();
        consumer1.join();
        consumer2.join();
        consumer3.join();
    }
}
