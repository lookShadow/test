package com.cn.ouyjs.thread.modelTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyjs
 * @date 2019/7/4 11:02
 */
public class Goods {
    public Goods(){

    }

    public Goods (int size) {
        this.size = size;
    }
    private List<Integer> list = new ArrayList<>();
    private int size = 15;

    synchronized void addGoods(int count) throws InterruptedException {
        if(count > size) {
            wait();
        }
        System.out.println(Thread.currentThread().getName()+"生产"+count+"件商品");
        list.add(count);
        notifyAll();
    }

    synchronized void removeGoods() throws InterruptedException {
        if (list.size() <= 0) {
            wait();
        }
        int res = list.get(0);
        list.remove(0);
        System.out.println(Thread.currentThread().getName()+"消费消费的产品:"+res);
        notifyAll();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
