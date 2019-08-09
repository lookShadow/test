package com.cn.ouyjs.thread.lock.productAndCustomer;

import java.util.List;

/**
 * @author ouyjs
 * @date 2019/8/9 10:45
 */
public class Customer {

    private Warehouse warehouse;

    Customer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void removeGoods(){
        List<Goods> goodsList = warehouse.getGoodsList();
        if (warehouse.getSize() <= 0) {
            System.out.println("当前仓库为空");
        }else {
            goodsList.remove(warehouse.getSize()-1);
            System.out.println("goodsList:"+goodsList);
        }
    }
}
