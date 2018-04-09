package com.cetiti.dsp.service.impl;

import com.cetiti.dsp.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl implements HelloService {

    //private static final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);
    @Override
    public void sayHello() {
        System.out.println("++++++++Aspect Test+++++++");
    }

    @Override
    public int beforeSayHello(String param) {
        System.out.println("++++++++Aspect Test+++++++" + param);
        return 1;
    }
}
