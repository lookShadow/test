package com.cn.ouyjs.test;

import java.math.BigDecimal;

/**
 * @author ouyjs
 * @date 2019/6/22 17:30
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
    }
}
