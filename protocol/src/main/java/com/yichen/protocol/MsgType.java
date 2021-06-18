package com.yichen.protocol;

import lombok.Getter;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 9:37
 */
public enum MsgType {
    /**
     * request 请求
     */
    REQUEST(0),
    /**
     * response 相应
     */
    RESPONSE(1),
    /**
     *  心跳
     */
    HEARTBEAT(2);

    @Getter
    private final int code;

    MsgType(int code) {
        this.code = code;
    }

    /**
     *  根据消息枚举 code查询具体的消息枚举值，如果查询不到默认为null
     * @param type  查询的消息枚举 code
     * @return  返回对应类型的消息类型枚举
     */
    public static MsgType findByType(int type){
        for(MsgType msgType:MsgType.values()){
            if(msgType.code==type){
                return msgType;
            }
        }
        return null;
    }

}
