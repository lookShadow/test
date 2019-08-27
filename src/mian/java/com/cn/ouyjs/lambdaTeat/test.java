package com.cn.ouyjs.lambdaTeat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ouyjs
 * @date 2019/8/6 12:12
 */
public class test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        listTest(list);
        System.out.println(list);

        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setUserName("admin");
        user.setPassWord("root");
        User user1 = new User();
        user1.setUserName("Tom");
        user1.setPassWord("cat");

        userList.add(user);
        userList.add(user1);

        System.out.println(userList);
        userListTest(userList);
        System.out.println(userList);
    }

    public static void listTest(List<String> list) {
        System.out.println(list);
        list = list.stream().filter(t-> !Objects.equals("a", t)).collect(Collectors.toList());
        System.out.println(list);
        list.add("d");
        System.out.println(list);
    }

    /**
     * 引用传递
     * @param list
     */
    public static void userListTest(List<User> list) {
        System.out.println(list);
        //list副本因为list = ****  改变了list副本的地址
        //list = list.stream().filter(t->!Objects.equals("admin", t.getUserName())).collect(Collectors.toList());
        list.forEach(t->{
            t.setUserName("a");
        });
    }
}
