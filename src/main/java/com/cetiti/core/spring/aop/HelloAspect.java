package com.cetiti.core.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class HelloAspect {
    //前置通知
    public void beforeAdvice(String param){
        System.out.println("==============before Advice" + param);
    }
    //后置通知
    public boolean afterFinallyAdvice(Object retVal){
        System.out.println("==============after Finally Advice: " + retVal);
        return true;
    }

    //环绕通知
    public Object aroundAdvice(ProceedingJoinPoint pip){
        System.out.println("==========around before advice");
        Object retVal = null;
        try {
            retVal = pip.proceed(new Object[] {"replace"});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("==========around after advice");
        return retVal;
    }
}
