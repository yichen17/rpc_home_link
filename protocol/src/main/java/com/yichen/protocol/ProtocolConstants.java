package com.yichen.protocol;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 16:13
 * @describe 协议常量值
 */
public class ProtocolConstants {
    /**
     *  数据基本长度
     */
    public static final int HEADER_TOTAL_LEN = 18;
    /**
     * 协议的魔法值 固定
     */
    public static final short MAGIC = 0x10;
    /**
     * 协议版本 固定
     */
    public static final byte VERSION = 0x1;

}
