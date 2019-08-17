package com.cn.ouyjs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ouyjs
 * @date 2019/8/14 19:29
 */
@RestController
@RequestMapping("/Hello")
public class Controller {
    @RequestMapping("/World")
    public String helloWorld(String s){
        System.out.println("传入的值为："+s);
        return "传入的值为："+s;
    }
}
