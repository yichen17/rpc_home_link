package com.yichen.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 13:52
 * @describe 通信协议
 * 
 * +---------------------------------------------------------------+
 * | 魔数 2B | 协议版本号 1B | 序列化算法 1B | 报文类型 1B  |
 * +---------------------------------------------------------------+
 * | 状态 1B |    消息 ID 8B     |      数据长度 4B     |
 * +---------------------------------------------------------------+
 * |          数据内容 （长度不定）                     |
 * +---------------------------------------------------------------+
 * 
 */
@Data
public class MiniProtocol<T> implements Serializable {
    private MsgHeader header;
    /**
     * 可以分为请求和相应，即 MiniRequest  MiniResponse
     */
    private T body;
}
