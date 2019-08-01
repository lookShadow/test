package com.cn.ouyjs.redis.redisTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author ouyjs
 * @date 2019/8/1 10:17
 */
public class ArticlesVoting {
    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;
    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        publishArticles(jedis, "article:110", "ouyang1");
        artilesVote(jedis, "ouyang1", "article:110");
    }

    /**
     * 发布文章
     * @param conn
     * @param article
     */
    public static void publishArticles(Jedis conn, String article, String user) {
        String articleId = String.valueOf(conn.incr("article:"));

        conn.sadd("voted:" + articleId, user);
        conn.expire("voted:" + articleId, ONE_WEEK_IN_SECONDS);

        long time = System.currentTimeMillis() - 1000;
        conn.zadd("time:", time, article);
    }

    /**
     * 文章投票
     * @param conn
     * @param user
     * @param article  article:110 文章:文章Id
     */
    public static void artilesVote(Jedis conn, String user, String article) {
        //计算文章截止日期
        long cutOff = System.currentTimeMillis()/1000 -ONE_WEEK_IN_SECONDS;
        if (conn.zscore("time:",article) < cutOff) {
            return;
        }
        String articleId =article.substring(article.indexOf(":") + 1);
        //第一次投票
        if (conn.sadd("voted:"+articleId, user) == 1) {
            conn.zincrby("score",123, article);
            conn.hincrBy(article,"voted",1);
        }
    }
}
