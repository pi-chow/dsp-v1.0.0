package com.cetiti.dsp.annotation;

public class AnnotationTest {

    @Message(num = 10)
    private static int a;

    @Message(num = 10, name = "jason")
    public void test(){
        System.out.println(a);
    }
}
