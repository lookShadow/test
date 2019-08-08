package com.cn.ouyjs.design.patterns.strategy;

/**
 * @author ouyjs
 * @date 2019/8/8 10:24
 * 策略模式:上下文
 */
public class AlgorithmContext {
    private Algorithm algorithm;
    public AlgorithmContext(Algorithm algorithm){
        this.algorithm = algorithm;
    }


    public void algorithm(){
        algorithm.algorithm();
    }
}
