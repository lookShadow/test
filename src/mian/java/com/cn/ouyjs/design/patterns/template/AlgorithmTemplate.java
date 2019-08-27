package com.cn.ouyjs.design.patterns.template;

import com.cn.ouyjs.design.patterns.strategy.Algorithm;


/**
 * @author ouyjs
 * @date 2019/8/8 10:21
 * 模板模式
 */
public abstract class AlgorithmTemplate implements Algorithm {

    @Override
    public void algorithm() {
        System.out.println("calss:"+this.getClass());
        prepareDate();
        restDate();
    }

    public void prepareDate(){

    }

    public void  restDate(){

    }
}
