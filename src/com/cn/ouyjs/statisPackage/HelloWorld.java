package com.cn.ouyjs.statisPackage;

/**
 * @author ouyjs
 * @date 2019/7/29 10:44
 */
public class HelloWorld {

    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("构造代码块");
    }
    HelloWorld(){
        System.out.println("构造函数");
    }

}
