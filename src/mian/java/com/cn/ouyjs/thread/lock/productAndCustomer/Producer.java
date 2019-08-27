package com.cn.ouyjs.thread.lock.productAndCustomer;

import java.util.List;
import java.util.Objects;

/**
 * @author ouyjs
 * @date 2019/8/9 10:37
 */
public class Producer {

    private Warehouse warehouse;
    Producer(Warehouse warehouse){
        this.warehouse = warehouse;
    }
    public void addGoods(Goods goods) {
        if (warehouse.getSize()> warehouse.getCapacity()) {
            System.out.println("仓库满了,不能添加商品");
        }else {
            List<Goods> goodsList = warehouse.getGoodsList();
            goodsList.add(goods);
            if (Objects.nonNull(goods)) {
                System.out.println("添加商品 商品的名字:"+goods.getName());
            }
        }
    }
}
