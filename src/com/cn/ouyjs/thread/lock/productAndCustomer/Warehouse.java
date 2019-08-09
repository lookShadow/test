package com.cn.ouyjs.thread.lock.productAndCustomer;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ouyjs
 * @date 2019/8/9 10:39
 *
 * 注意事项:
 *  Condition对象将Object中的 wait() notify() notifyAll()封装
 *  Condition 中的方法对应 await对应 Object中的wait  Condition也继承了Object 所以也有wait方法 注意注意注意!!!!
 *  Condition 中的方法对应 signal Object中的notify
 *  Condition 中的方法对应 signalAll Object中的notifyAll
 */
public class Warehouse {

    private ReentrantLock lock = new ReentrantLock();
    Condition customerCondition = lock.newCondition();
    Condition produceCondition = lock.newCondition();
    private List<Goods> goodsList = new ArrayList<>();

    private Integer capacity;


    Warehouse(Integer capacity) {
        this.capacity = capacity;
    }

    public void addGoods(Goods goods) {
        try {
            lock.lock();
            while (this.getSize() >= capacity) {
                System.out.println("仓库满了,不能添加商品");
                produceCondition.await();
            }
            goodsList.add(goods);
            System.out.println("add thread name:" + Thread.currentThread().getName() + "  number:" + this.getSize());
            customerCondition.signal();

        } catch (InterruptedException e) {
            System.out.println("中断异常");
        } finally {
            lock.unlock();
        }
    }

    public void removeGoods() {
        try {
            lock.lock();
            while (this.getSize() <= 0) {
                System.out.println("当前仓库为空");
                customerCondition.await();
            }
            goodsList.remove(this.getSize() - 1);
            System.out.println("remove thread name:" + Thread.currentThread().getName() + "  number:" + this.getSize());
            produceCondition.signal();

        } catch (InterruptedException e) {
            System.out.println("中断异常");
        } finally {
            lock.unlock();
        }
    }

    public Integer getSize() {
        if (CollectionUtils.isNotEmpty(goodsList)) {
            return goodsList.size();
        }
        return 0;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
