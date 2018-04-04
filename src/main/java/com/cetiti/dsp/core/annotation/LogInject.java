package com.cetiti.dsp.core.annotation;

import java.lang.annotation.*;

/**
 * 描述：自定义注解（用户注入Logger对象）
 * @author zhouliyu
 *
 * */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface LogInject {

}
