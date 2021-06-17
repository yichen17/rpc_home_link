package com.yichen.serialization;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 15:41
 * @describe  工厂类，构造指定类型的序列化算法
 */
public class SerializationFactory {

    public static RpcSerialization getRpcSerialization(byte serializationType) {
        SerializationTypeEnum typeEnum = SerializationTypeEnum.findByType(serializationType);

        switch (typeEnum) {
            case HESSIAN:
                return new HessianSerialization();
            case JSON:
                return new JsonSerialization();
            default:
                throw new IllegalArgumentException("serialization type is illegal, " + serializationType);
        }
    }
}
