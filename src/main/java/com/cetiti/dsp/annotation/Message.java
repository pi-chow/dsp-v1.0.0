package com.cetiti.dsp.annotation;


import java.lang.annotation.*;

/***
 * @author  zhouliyu
 * */

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Message {

    String name()  default "zhouliyu";
    int num() default 0;
}
