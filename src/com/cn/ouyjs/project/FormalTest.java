package com.cn.ouyjs.project;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ouyjs
 * @date 2019/6/13 14:20
 */
public class FormalTest {

    public static void main(String[] args) {
        StringBuilder totalPriceFormula = new StringBuilder("=SUM(");
        //记录公式
        if (StringUtils.equals(":", String.valueOf(totalPriceFormula.charAt(totalPriceFormula.length() - 1)))) {
            totalPriceFormula.setLength(totalPriceFormula.length() - 1);
            System.out.println("1____totalPriceFormula=" + totalPriceFormula);
        }
        totalPriceFormula.append(")");
        System.out.println("2____totalPriceFormula=" + totalPriceFormula);
        totalPriceFormula.setLength(5);
        System.out.println("3____totalPriceFormula=" + totalPriceFormula);
    }
}
