package com.cn.ouyjs.jvmTest;

/**
 * @author ouyjs
 * @date 2019/7/31 16:53
 * 自动装箱
 */
public class AutomaticPacking {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        //常量池里面存了 -128到127的值
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c ==(a+b));
        System.out.println(c.equals(a+b));
        // == 在不遇到算数运算的时候不会自动拆箱
        System.out.println(g == (a+b));
        //Long.equals 不会进行类型转换 自动返回false
        System.out.println(g.equals(a+b));
    }
}
