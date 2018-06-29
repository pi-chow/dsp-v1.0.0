package com.cetiti.core.reflect;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("我需要被代理： " + name);
    }
}
