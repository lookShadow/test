package com.cn.ouyjs.thread.lock.productAndCustomer;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ouyjs
 * @date 2019/8/9 10:50
 */
public class ProducerThread implements Runnable {
    private Warehouse warehouse;
    private Goods goods;
    public ProducerThread(Warehouse warehouse,Goods goods) {
        this.warehouse = warehouse;
        this.goods = goods;
    }

    @Override
    public void run() {
            while (true) {
                warehouse.addGoods(goods);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}