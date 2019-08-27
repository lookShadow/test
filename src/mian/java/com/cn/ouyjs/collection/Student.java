package com.cn.ouyjs.collection;

import java.util.List;
import java.util.Map;

/**
 * @author ouyjs
 * @date 2019/8/15 19:51
 */
public class Student {
    Map<Long, List<User>> userListMap;

    public Map<Long, List<User>> getUserListMap() {
        return userListMap;
    }

    public void setUserListMap(Map<Long, List<User>> userListMap) {
        this.userListMap = userListMap;
    }
}
