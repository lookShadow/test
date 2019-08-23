package com.cn.ouyjs.calssLoad;

/**
 * @author ouyjs
 * @date 2019/8/21 17:18
 * 类加载: 加载->验证->准备->解析->初始化
 * 初始化阶段中四种特殊的初始化
 * 1.final修饰的类不会发生初始化,在编译的期间加入到了常量池
 * 2.反射, 通过反射找到的类,如果没有加载的话,需要先类加载
 * 3.继承,初始化一个类的时候,如果这个类有父类,先初始化父类
 * 4.方法依赖其他类,先初始化方法类,在初始化"其他类"
 * 5.动态语言支持
 */
public class ClassLoadTest {
    public ClassLoadTest() {
        System.out.println("ClassLoadTest");
    }

    public static void classLoadTest(){
        System.out.println("classLoadTest");
    }
}
