package com.openragonhuang.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class CglibProxyTest {
    @Test
    public void proxyTest(){
        CglibProxy cglibProxy = new CglibProxy();
        HelloJava proxy = (HelloJava)cglibProxy.getProxy(HelloJava.class);
        proxy.sayHelloJava();
    }
}