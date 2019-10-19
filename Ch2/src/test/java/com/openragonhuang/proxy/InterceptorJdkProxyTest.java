package com.openragonhuang.proxy;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class InterceptorJdkProxyTest {

    @Test
    public void bind() {
        HelloWorld helloWorld = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), new Interceptor() {
            @Override
            public boolean before(Object target, Object proxy, Method method, Object[] args) {
                System.out.println("拦截器 Before");
                return true;
            }

            @Override
            public void around(Object target, Object proxy, Method method, Object[] args) {
                System.out.println("拦截器 Around");
            }

            @Override
            public void after(Object target, Object proxy, Method method, Object[] args) {
                System.out.println("拦截器 After");
            }
        });
        helloWorld.sayHelloWorld();
    }
}