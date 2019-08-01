package com.cn.ouyjs.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author ouyjs
 * @date 2019/8/1 10:17
 */
public class RedisUtills {
    private RedisUtills(){}

    private  static  JedisPool jedisPool = new JedisPool();
    public static String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, value);
        } finally {
            jedis.close();
        }
        return key;
    }

    public static String get(String key) {
        String value = "";
        Jedis jedis = jedisPool.getResource();
        try {
            value = jedis.get(key);
        } finally {
            jedis.close();
        }
        return value;
    }

}
