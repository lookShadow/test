package com.cn.ouyjs.RabbitMq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;

/**
 * @author ouyjs
 * @date 2019/8/1 17:57
 */
@SpringBootTest(classes = ThreadTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ThreadTest {
    private  final String url = "www.baidu.com";
    private  RestTemplate restTemplate = new RestTemplate();
    private static final int USER_NUMS = 1;

    @Test
    public void main(String[] args) {
        for (int i = 0; i < USER_NUMS; i++ ) {
            new Thread(new MyThread()).start();
        }
    }

    public  class MyThread implements Runnable{

        @Override
        public void run() {
            String result = restTemplate.getForEntity(url,String.class).getBody();
            System.out.println(result);
        }
    }
}
