package com.cetiti.core.reflect;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloServiceCgLib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback((Callback) this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是代理方法");
        Object result = null;
        System.out.println("反射前");
        result =method.invoke(target,objects);
        System.out.println("反射后");
        return result;
    }

    public static void main(String[] args){
        HelloServiceCgLib helloHandler = new HelloServiceCgLib();
        HelloService proxy =(HelloService)helloHandler.getInstance(new HelloServiceImpl());
        proxy.sayHello("lyzhou");
    }


}
