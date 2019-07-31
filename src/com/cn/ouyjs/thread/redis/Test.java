package com.cn.ouyjs.thread.redis;

/**
 * @author ouyjs
 * @date 2019/7/29 9:16
 */
public class Test {
    private static Integer count = 100;
    public static void main(String[] args) {
        ShareParam shareParam = new ShareParam(100);
        TestThread testThread = new TestThread(count);
        Thread thread = new Thread(testThread);
        Thread thread1 = new Thread(testThread);
        Thread thread2 = new Thread(testThread);

        thread.start();
        thread1.start();
        thread2.start();
    }
}
