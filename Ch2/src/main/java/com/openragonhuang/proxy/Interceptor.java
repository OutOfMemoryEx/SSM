package com.openragonhuang.proxy;

import java.lang.reflect.Method;

public interface Interceptor {
    boolean before(Object target, Object proxy, Method method, Object[] args);
    void around(Object target, Object proxy, Method method, Object[] args);
    void after(Object target, Object proxy, Method method, Object[] args);
}
