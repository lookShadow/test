package com.cn.ouyjs.thread.test;

/**
 * @author ouyjs
 * @date 2019/6/20 17:13
 */
public class NewOrTerminatedTest {

    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println(thread.getState());

        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
