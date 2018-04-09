package com.cetiti.dsp.core.injector;

import com.cetiti.dsp.core.annotation.MapperInject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * 描述：自定义Mapper注入器，用户注解注入Mapper对象
 * @author zhouliyu
 * */

public class MapperInjector implements BeanPostProcessor{
    //根据Spring配置获取mybatis中sqlSessionTemplate 模板
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 实例化、依赖注入完毕，在调用显示的初始化之前完成一些定制的初始化任务（前置处理器）
     * */
    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(),new ReflectionUtils.FieldCallback(){
            //通过注解（反射）创建Mapper实例
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                ReflectionUtils.makeAccessible(field);
                if(field.isAnnotationPresent(MapperInject.class)){
                    MapperInject annotation = field.getAnnotation(MapperInject.class);
                    Class<?> clazz = annotation.value();
                    field.set(bean,sqlSessionTemplate.getMapper(clazz));
                }
            }
        });

        return null;
    }

    /**
     * 实例化、依赖注入、初始化完毕时执行（后置处理器）
     * */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
