package com.cn.ouyjs.lambdaTeat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ouyjs
 * @date 2019/7/6 11:09
 */
public class FilterTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("java","asdb","big","tom","cat");
        List list1 = list.stream().filter(s -> !"java".equals(s)).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list1);
    }
}
