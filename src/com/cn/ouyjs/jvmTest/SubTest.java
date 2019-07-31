package com.cn.ouyjs.jvmTest;

/**
 * @author ouyjs
 * @date 2019/7/31 14:59
 */
public class SubTest extends ParentTest {
    private static int B = A;

    /*
        静态变量和静态代码块运行顺序只和代码编写顺序有关.
        为了符合思维,先声明再计算的方式 静态变量应该放在前面
     */
    public static void main(String[] args) {
        System.out.println(SubTest.B);
    }
}
