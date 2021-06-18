package com.yichen.protocol;

import lombok.Getter;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 9:35
 * @describe  消息状态枚举
 */
public enum MsgStatus {
    /**
     * 请求成功
     */
    SUCCESS(0),
    /**
     * 请求失败
     */
    FAIL(1);
    @Getter
    private final int code;

    MsgStatus(int code) {
        this.code = code;
    }
}
