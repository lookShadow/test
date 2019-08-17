package com.cn.ouyjs.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ouyjs
 * @date 2019/8/14 20:29
 */
@FeignClient(value = "eureka-service")
@RequestMapping("/Hello")
public interface TestService {
    //restful api 调用
    @GetMapping("/World")
    String helloWorld(@RequestParam("s") String s);
}
