package com.yichen.codec;

import com.yichen.protocol.MiniProtocol;
import com.yichen.protocol.MsgHeader;
import com.yichen.serialization.RpcSerialization;
import com.yichen.serialization.SerializationFactory;
import com.yichen.serialization.SerializationTypeEnum;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.Serializable;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 15:47
 * @describe  自定义加码器
 * +---------------------------------------------------------------+
 * | 魔数 2B | 协议版本号 1B | 序列化算法 1B | 报文类型 1B  |
 * +---------------------------------------------------------------+
 * | 状态 1B |    消息 ID 8B     |      数据长度 4B     |
 * +---------------------------------------------------------------+
 * |          数据内容 （长度不定）                     |
 * +---------------------------------------------------------------+
 */
public class MiniEncoder extends MessageToByteEncoder<MiniProtocol<Object>> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MiniProtocol<Object> msg, ByteBuf out) throws Exception {
        // 自定义的通用 编码器，故 MiniProtocol<Object> 用了 Object 而没有具体指定 request 或者 response
        MsgHeader header=msg.getHeader();
        out.writeShort(header.getMagic());
        out.writeByte(header.getVersion());
        out.writeByte(header.getSerialization());
        out.writeByte(header.getMsgType());
        out.writeByte(header.getStatus());
        out.writeLong(header.getRequestId());
        RpcSerialization serializable= SerializationFactory.getRpcSerialization(header.getSerialization());
        byte[] data= serializable.serialize(msg.getBody());
        out.writeInt(data.length);
        out.writeBytes(data);
    }
}
