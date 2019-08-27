package com.cn.ouyjs.jdk;

/**
 * @author ouyjs
 * @date 2019/7/26 9:38
 */
public class LookBookTest {
    public static void main(String[] args) {
        LookBooK lookBooK = new LookBookImpl();
        LookBookHande lookBookHande = new LookBookHande(lookBooK);
        lookBookHande.look();
    }
}
