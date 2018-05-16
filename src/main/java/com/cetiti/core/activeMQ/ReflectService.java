package com.cetiti.core.activeMQ;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectService {

    public void sayHello(String name){
        System.out.println(name);
    }
    public static void main(String[] args){
        try {
            Object service = Class.forName(ReflectService.class.getName()).newInstance();
            Method method = service.getClass().getMethod("sayHello",String.class);
            method.invoke(service,"liyuzhou");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
