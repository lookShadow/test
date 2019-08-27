package com.cn.ouyjs.redis.SocketServerRedis;

import redis.clients.jedis.Jedis;

/**
 * @author ouyjs
 * @date 2019/8/1 10:02
 */
public class JedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("reids", "jedis");
        jedis.close();
    }
}
