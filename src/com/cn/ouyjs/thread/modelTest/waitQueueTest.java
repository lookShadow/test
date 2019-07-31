package com.cn.ouyjs.thread.modelTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyjs
 * @date 2019/7/4 11:48
 */
public class waitQueueTest {

    private List<Thread> list = new ArrayList<>();

    private static final int SIZE = 10;

    public int getSize(){
        if(list.size() > SIZE) {
            throw new NullPointerException();
        }
        return list.size();
    }

    public void inQueue(Thread thread) {
        if(list.size() > SIZE) {
            throw new NullPointerException();
        }
        list.add(thread);
    }

}
