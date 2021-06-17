package com.yichen.serialization;

import lombok.Getter;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 15:41
 * @describe 序列化方式枚举以及 判断使用了那种序列化方式，默认使用hessian
 */
public enum SerializationTypeEnum {
    /**a
     * Hessian 序列化
     */
    HESSIAN(0x10),
    /**
     * json 序列化
     */
    JSON(0x20);

    @Getter
    private final int type;

    SerializationTypeEnum(int type) {
        this.type = type;
    }

    public static SerializationTypeEnum findByType(byte serializationType) {
        for (SerializationTypeEnum typeEnum : SerializationTypeEnum.values()) {
            if (typeEnum.getType() == serializationType) {
                return typeEnum;
            }
        }
        return HESSIAN;
    }
}
