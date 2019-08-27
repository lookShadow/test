package com.cn.ouyjs.jdk.jdk;

/**
 * @author ouyjs
 * @date 2019/7/26 9:42
 */
public class BookFacade implements jdk.jdk.IBookFacade {
    @Override
    public void addBook(String name) {
        System.out.println("add book" + name);
    }

    @Override
    public void deleBook() {
        System.out.println("delete book");
    }
}
