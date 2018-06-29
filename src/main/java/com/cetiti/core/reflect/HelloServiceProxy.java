package com.cetiti.core.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是代理方法");
        Object result = null;
        System.out.println("反射前");
        result = method.invoke(target, args);
        System.out.println("反射后");
        return result;
    }

    public static void main(String[] args){
        HelloServiceProxy helloHandler = new HelloServiceProxy();
        HelloService proxy = (HelloService)helloHandler.bind(new HelloServiceImpl());
        proxy.sayHello("lyzhou");
    }
}
