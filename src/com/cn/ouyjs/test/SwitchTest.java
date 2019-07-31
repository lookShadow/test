package com.cn.ouyjs.test;

/**
 * @author ouyjs
 * @date 2019/6/22 17:29
 */
public class SwitchTest {
    public static void main(String[] args) {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
