package com.cetiti.dsp.annotation;

import com.cetiti.dsp.core.annotation.LogInject;
import org.slf4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * 通过反射机制
 * @author zholiyu
 *
 * */

public class MessageProcessor {

    @LogInject
    private static Logger log;

    public static void main(String[] args){

        try {
            //加载Message.class
            Class clazz = MessageProcessor.class.getClassLoader().loadClass("com.cetiti.dsp.annotation.AnnotationTest");

            //获取属性
            Field[] fields = clazz.getDeclaredFields();
            //遍历属性
            for(Field field : fields){
                Message message = field.getAnnotation(Message.class);
                System.out.println("name:" + message.name() + " num:" + message.num());
            }

            //获取类中的方法
            Method[] methods = clazz.getMethods();
            //遍历方法
            for(Method method : methods){

                //判断方法是否带有Message注解
                if(method.isAnnotationPresent(Message.class)){
                    Message message = method.getAnnotation(Message.class);
                    System.out.println("name:" + message.name() + " num:" + message.num());
                }
            }
            log.info("成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.info("失败");
        }
    }
}
