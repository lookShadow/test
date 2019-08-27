package com.cn.ouyjs.jdk;

/**
 * @author ouyjs
 * @date 2019/7/26 9:37
 */
public class LookBookHande implements LookBooK {
    private LookBooK booK;

    public LookBookHande(LookBooK booK) {
        this.booK = booK;
    }

    @Override
    public void look() {
        booK.look();
    }
}
