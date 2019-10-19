package com.openragonhuang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    private Object target;

    public <E> Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("真是对象调用之前逻辑");
        Object ret = method.invoke(target, args);
        System.out.println("真是对象调用之后逻辑");
        return ret;
    }
}
