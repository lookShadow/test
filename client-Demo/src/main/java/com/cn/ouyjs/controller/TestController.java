package com.cn.ouyjs.controller;

import com.cn.ouyjs.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ouyjs
 * @date 2019/8/14 20:26
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;
    @RequestMapping("/Consumer")
    public String Consumer(String s){
        System.out.println("传入的值为：" + s);
        return testService.helloWorld(s);
    }
}
