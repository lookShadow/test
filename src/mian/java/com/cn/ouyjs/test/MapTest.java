package com.cn.ouyjs.test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ouyjs
 * @date 2019/6/22 17:59
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        System.out.println(map.get(1));

        System.out.println(LocalDate.now());;

        String startTime = "2019-04-19";
        System.out.println(LocalDate.parse(startTime).plusDays(1));
        System.out.println(LocalDate.parse(startTime).minusDays(1));
    }
}
