package com.cetiti.dsp.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 描述：面向切面编程（自定义日志输出）（order=3 优先级低）
 *
 * @author zhouliyu
 * */
@Component
@Aspect
@Order(3)
public class LogAspect {

    //日志记录类
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    //切入点表达式
    @Pointcut("execution(* com.cetiti.dsp.annotation.*.*(..))")
    public void logPointCut() {

    }

    /**
     * 返回通知
     * @param joinPoint 目标类连接点对象
     * @param result 返回结果
     * */
    @AfterReturning(value = "logPointCut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> parameters = Arrays.asList(joinPoint.getArgs());
        if(parameters.size() > 0){

        }else{
            log.info("[LogAspect 返回通知] 执行类方法 : " + className + "." + methodName + "(), 返回结果 : " + result);
        }
    }

    /**
     * 异常通知
     *
     * @param joinPoint 目标类连接点对象
     * @param exception 异常类
     */
    @AfterThrowing(value = "logPointCut()", throwing = "exception")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception exception) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        List<Object> parameters = Arrays.asList(joinPoint.getArgs());
        if (parameters.size() > 0) {
            log.warn("[LogAspect 异常通知] 执行类方法 : " + className + "." + methodName + "(" + parameters + "), 异常 : " + exception.getMessage());
        } else {
            log.warn("[LogAspect 异常通知] 执行类方法 : " + className + "." + methodName + "(), 异常 : " + exception.getMessage());
        }
    }
}
