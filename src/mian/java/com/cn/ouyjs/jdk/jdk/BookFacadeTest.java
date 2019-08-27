package com.cn.ouyjs.jdk.jdk;

/**
 * @author ouyjs
 * @date 2019/7/26 9:45
 */
public class BookFacadeTest {
    public static void main(String[] args) {
        BookFacadeFactory bookFacadeFactory = new BookFacadeFactory();
        jdk.jdk.IBookFacade bookFacade = (jdk.jdk.IBookFacade)bookFacadeFactory.bind(new BookFacade());
        bookFacade.addBook("三国");
        jdk.jdk.InterfaceTest interfaceTest = null;
        interfaceTest.hashCode();
        bookFacadeFactory.hashCode();
    }
}
