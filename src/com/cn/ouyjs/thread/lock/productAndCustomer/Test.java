package com.cn.ouyjs.thread.lock.productAndCustomer;

import java.math.BigDecimal;

/**
 * @author ouyjs
 * @date 2019/8/9 10:48
 */
public class Test {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(10);

        /*Producer producer = new Producer(warehouse);
        producer.addGoods(goods);*/
        for (int i=0; i< 3; i++){
            Goods goods = new Goods();
            goods.setName("苹果"+i);
            goods.setNumber(1);
            goods.setPrice(new BigDecimal(1));
            new Thread(new ProducerThread(warehouse, goods)).start();
        }
        new Thread(new CustomerThread(warehouse)).start();
    }
}
