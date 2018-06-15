package com.cetiti.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
        Hello hello1 = context.getBean("helloImpl",Hello.class);
        //hello1.sayHello("test");
       // hello1.afterSayHello();
        hello1.sayAround("hh");
    }

}
