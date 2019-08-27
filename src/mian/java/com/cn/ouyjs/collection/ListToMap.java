package com.cn.ouyjs.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ouyjs
 * @date 2019/8/15 19:38
 * list map 转换
 */
public class ListToMap {
    public static void main(String[] args) {
        //map.values() map不能为空  可以是空对象
        //new new ArrayList<>(null) 不能为空 可以是空对象
        mapToList();
       mapTest();
       listInMap();
    }

    private static void listInMap() {
        Student student = new Student();
        Map<Long, List<User>> userListMap = new HashMap<>();
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setName("Tom");
        user.setPsw("Cat");
        User user1 = new User();
        user1.setName("Tom1");
        user1.setPsw("Cat1");
        User user2 = new User();
        user2.setName("Tom2");
        user2.setPsw("Cat2");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userListMap.put(1L, userList);
        student.setUserListMap(userListMap);
        test(student);
        System.out.println(student.getUserListMap());
    }

    private static void test(Student student) {
        Map<Long, List<User>> userListMap = student.getUserListMap();
        userListMap.values().forEach(t->{
            t.forEach(k->{
                k.setName("king");
            });
        });
        System.out.println(userListMap);
    }

    private static void mapToList() {
         /*Map<Long, String> map = null;
        System.out.println(map.values());
        List<String> list = new ArrayList<>(map.values());
        System.out.println(list);*/
        Map<Long, String> map1 = new HashMap<>();
        System.out.println(map1.values());
        List<String> list1 = new ArrayList<>(map1.values());
        System.out.println(list1);
    }

    private static void mapTest() {

        Map<Long, User> map2 = new HashMap<>();
        User user = new User();
        user.setName("Tom");
        user.setPsw("Cat");
        map2.put(1L, user);
        User user1 = new User();
        user1.setName("Tom1");
        user1.setPsw("Cat1");
        map2.put(2L,user1);
        User user2 = new User();
        user2.setName("Tom2");
        user2.setPsw("Cat2");
        map2.put(3L, user2);
        map2.values().forEach(t->{
            t.setName("king");
        });
        System.out.println(map2);
    }
}
