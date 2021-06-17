package com.yichen.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 13:56
 * @describe  消息头
 */
@Data
public class MsgHeader  implements Serializable{
    /**
     * 魔术值
     */
    private short magic;
    /**
     * 协议版本号
     */
    private byte version;
    /**
     * 序列化算法
     */
    private byte serialization;
    /**
     * 报文类型
     */
    private byte msgType;
    /**
     * 状态
     */
    private byte status;
    /**
     * 消息ID
     */
    private long requestId;
    /**
     * 数据长度
     */
    private int msgLen;

}
