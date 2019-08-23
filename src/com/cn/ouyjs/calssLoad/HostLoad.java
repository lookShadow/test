package com.cn.ouyjs.calssLoad;

/**
 * @author ouyjs
 * @date 2019/8/21 17:29
 */
public class HostLoad extends ClassLoader {

    @Override
    protected Class<?> findClass(String s) throws ClassNotFoundException {
        return super.findClass(s);
    }
}
