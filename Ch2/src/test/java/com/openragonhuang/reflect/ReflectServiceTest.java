package com.openragonhuang.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class ReflectServiceTest {
    @Test
    public void reflectTest(){

        ReflectService reflectServiceObj;
        try {
            //通过反射创建对象
            Class aClass = Class.forName("com.openragonhuang.reflect.ReflectService");
            reflectServiceObj = (ReflectService) aClass.getConstructor().newInstance();
            //通过反射调用方法
            aClass.getMethod("setName", String.class).invoke(reflectServiceObj, "llm");
            aClass.getMethod("sayHello").invoke(reflectServiceObj);
            aClass.getMethod("sayHello", String.class).invoke(reflectServiceObj, "hkl");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}