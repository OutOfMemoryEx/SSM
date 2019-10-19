package com.openragonhuang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {
    private Object target;
    private Interceptor interceptor;

    public InterceptorJdkProxy(Object target) {
        this.target = target;
    }

    public InterceptorJdkProxy(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    public InterceptorJdkProxy(Object target, String interceptorClassName) {
        this.target = target;

        if(interceptorClassName != null && interceptorClassName.length() > 0){
            try {
                this.interceptor = (Interceptor) Class.forName(interceptorClassName).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static Object bind(Object target, Interceptor interceptor){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InterceptorJdkProxy(target, interceptor));
    }

    public static Object bind(Object target, String interceptorClassName){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InterceptorJdkProxy(target, interceptorClassName));
    }

    public static Object bind(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InterceptorJdkProxy(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(interceptor == null){
            return method.invoke(target, args);
        }

        Object ret = null;
        if(interceptor.before(target, proxy, method, args)){
            ret = method.invoke(target, args);
        }else{
            interceptor.around(target, proxy, method, args);
        }
        interceptor.after(target, proxy, method, args);

        return ret;
    }
}
