package com.cn.ouyjs.test;

/**
 * @author ouyjs
 * @date 2019/8/8 16:18
 */
public class IfTest {

    public static void main(String[] args) {
        System.out.println(ifTest());
    }

    public static Boolean ifTest(){
        for(;;) {
            String a = "a";
            if ("b" == a)
                return false;
        }
    }
}
