package com.yichen.cook.food.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 11:19
 * @describe  自定义注解，用于标记暴露的服务接口
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface RpcService {
    Class<?> serviceInterface() default Object.class;

    String serviceVersion() default "1.0";
}
