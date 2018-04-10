package com.cetiti.core.annotation;

import java.lang.annotation.*;

/**
 * 描述：自定义注解（注入Mapper对象）
 * @author zhouliyu
 *
 * */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MapperInject {
    /**
     * 对象类型（默认 Object）
     *
     * */
    Class<?> value() default java.lang.Object.class;
}
