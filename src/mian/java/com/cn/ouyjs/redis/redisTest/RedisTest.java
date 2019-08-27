package com.cn.ouyjs.redis.redisTest;

import redis.RedisUtills;

/**
 * @author ouyjs
 * @date 2019/8/1 10:21
 */
public class RedisTest {
    public static void main(String[] args) {
        System.out.println(RedisUtills.set("redis", "Jedis"));
        System.out.println(RedisUtills.get("redis"));
    }
}
