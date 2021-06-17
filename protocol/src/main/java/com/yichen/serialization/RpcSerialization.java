package com.yichen.serialization;

import java.io.IOException;

/**
 * @author E480
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 15:07
 * @describe 序列化接口
 */
public interface RpcSerialization {
    /**
     * 用于将 某一个对象序列化成byte数组
     *
     * @param obj 序列化对象
     * @param <T> 序列化的对账类型
     * @return 序列化的byte数组
     */
    <T> byte[] serialize(T obj)throws IOException;

    /**
     * 将byte 数组转换成指定的对象
     *
     * @param bytes 反序列化数据源
     * @param clazz 反序列化成的类对象
     * @param <T>  反序列化的类型
     * @return T
     */
    <T> T deserialize(byte[] bytes,Class<T> clazz)throws IOException;
}
