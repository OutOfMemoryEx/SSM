package com.openragonhuang.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class JdkProxyTest {

    @Test
    public void bind() {
        JdkProxy jdkProxy = new JdkProxy();
        HelloWorld obj = (HelloWorld) jdkProxy.bind(new HelloWorldImpl());
        obj.sayHelloWorld();
    }
}