package com.cetiti.core.spring;

import com.cetiti.core.spring.Hello;

/**
 * 通过构造方法
 *
 * */
public class HelloImpl implements Hello {

    private String message;
    private int index;

    public HelloImpl() {
        this.message = "hello";
        this.index = 0;
    }

    public HelloImpl(String message,int index) {
        this.message = message;
        this.index = index;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void sayHello(String param) {
        System.out.println(index+":"+message);
    }

    @Override
    public boolean afterSayHello() {
        System.out.println("after returning");
        return true;
    }

    @Override
    public void sayAround(String param) {
        System.out.println("===========around param: " + param);
    }

}
