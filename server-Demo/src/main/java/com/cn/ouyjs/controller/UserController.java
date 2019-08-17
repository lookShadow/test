package com.cn.ouyjs.controller;

import com.cn.ouyjs.dao.UserDao;
import com.cn.ouyjs.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ouyjs
 * @date 2019/8/15 9:27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserDao userDao;

    @RequestMapping("/save")
    private String save(){
        User user = new User();

        user.setId(123L);
        user.setUserName("Tom");
        user.setPasswd("Cat");
        userDao.saveUser(user);
        System.out.println(user);
        return "success";
    }
}
