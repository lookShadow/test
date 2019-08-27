package com.cn.ouyjs.design.patterns.strategy;

import com.cn.ouyjs.design.patterns.template.AlgorithmTemplate;

/**
 * @author ouyjs
 * @date 2019/8/8 10:22
 * 加法
 */

public class Add extends AlgorithmTemplate {

    @Override
    public void prepareDate() {
        System.out.println("Add prepareDate Class:"+this.getClass());
    }

    @Override
    public void restDate() {
        System.out.println("Add restDate");
    }
}
