package com.cn.ouyjs.dao;


import com.cn.ouyjs.entity.User;

/**
 * @author ouyjs
 * @date 2019/8/15 9:23
 */
public interface UserDao {

    void saveUser(User user);

    void deleteUser(Long id);

    User findById(Long id);

    void updateUser(User user);
}
