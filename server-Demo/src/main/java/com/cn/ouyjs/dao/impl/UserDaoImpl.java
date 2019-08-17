package com.cn.ouyjs.dao.impl;

import com.cn.ouyjs.dao.UserDao;
import com.cn.ouyjs.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ouyjs
 * @date 2019/8/15 9:25
 */
@Service
public class UserDaoImpl implements UserDao {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        mongoTemplate.remove(id);
    }

    @Override
    public User findById(Long id) {
      //  Query query = new Query(Criteria.where("id").is(id));

        return null;
    }

    @Override
    public void updateUser(User user) {

    }
}
