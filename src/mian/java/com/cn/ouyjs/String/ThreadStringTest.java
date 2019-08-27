package com.cn.ouyjs.String;

/**
 * @author ouyjs
 * @date 2019/8/20 11:19
 */
public class ThreadStringTest {
    public static void main(String[] args) {
        for (int i=0; i< 10;i++) {
            final String[] s = {"a"};
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                    s[0] += String.valueOf(finalI);
                    System.out.println(s[0]);
                }
            }).start();
        }
    }
}
