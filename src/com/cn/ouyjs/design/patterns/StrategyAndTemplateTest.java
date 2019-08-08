package com.cn.ouyjs.design.patterns;

import com.cn.ouyjs.design.patterns.strategy.Add;
import com.cn.ouyjs.design.patterns.strategy.AlgorithmContext;

/**
 * @author ouyjs
 * @date 2019/8/8 10:25
 * 策略模式和模板模式的结合
 */
public class StrategyAndTemplateTest {

    public static void main(String[] args) {
        Add add = new Add();
        AlgorithmContext context = new AlgorithmContext(add);
        context.algorithm();;
    }
}
