package com.yichen.register;

import lombok.Getter;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 10:22
 * @describe  注册枚举类型
 */
public enum RegisterType {
    /**
     * 通过zookeeper 实现注册
     */
    ZOOKEEPER,
    /**
     * 通过 eureka 实现注册
     */
    EUREKA;
}
