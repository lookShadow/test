package com.cn.ouyjs.jvmTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyjs
 * @date 2019/7/6 14:19
 */
public class JvmTest {
    static class Test{
        private int i = 0;
        private void setStack(){
            i++;
            System.out.println(i);
            setStack();
        }
    }

    public static void main(String[] args) {
        OutOfMemoryErrorTest();
    }

    public static void OutOfMemoryErrorTest(){
        List<Test> list = new ArrayList<>();
        while (true){
            System.out.println(list.size());
            list.add(new Test());
        }
    }

    public static void StackOverflowErroTest(){
        Test test = new Test();
        test.setStack();
    }
}
