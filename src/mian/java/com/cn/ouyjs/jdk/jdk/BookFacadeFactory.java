package com.cn.ouyjs.jdk.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ouyjs
 * @date 2019/7/26 9:42
 */
public class BookFacadeFactory implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object result = null;
        Class clazz = method.getDeclaringClass();
        if (Object.class.equals(clazz)) {
            result = method.invoke(this, objects);
        }
   /*     if (method.getName().equals("addBook")) {
            System.out.println("add");
            result = method.invoke(target, objects);
        }*/
        return result;
    }
}
