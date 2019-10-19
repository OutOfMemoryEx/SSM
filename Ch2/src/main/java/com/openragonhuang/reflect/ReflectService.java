package com.openragonhuang.reflect;


public class ReflectService {
    private String name;

    public ReflectService() {
    }

    public ReflectService(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Hello "+name);
    }

    public void sayHello(String name){
        System.out.println("Hello "+name);
    }
}
