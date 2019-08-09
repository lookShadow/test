package com.cn.ouyjs.thread.lock.productAndCustomer;

import java.util.List;

/**
 * @author ouyjs
 * @date 2019/8/9 10:52
 */
public class CustomerThread implements Runnable {
    private Warehouse warehouse;

    public CustomerThread(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true){
            warehouse.removeGoods();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
