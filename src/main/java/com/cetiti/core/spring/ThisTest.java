package com.cetiti.core.spring;

public class ThisTest {
    private int num = 0;
    private String name = "lyzhou";

    public ThisTest(int num){
        this.num = num;
    }

    public ThisTest(String name){
        this.name = name;
    }

    public ThisTest(int num, String name){
        this(name);
        this.num = num;
    }
}
