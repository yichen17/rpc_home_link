package com.yichen.codec;

import com.yichen.core.common.MiniRequest;
import com.yichen.core.common.MiniResponse;
import com.yichen.protocol.MiniProtocol;
import com.yichen.protocol.MsgHeader;
import com.yichen.protocol.MsgType;
import com.yichen.protocol.ProtocolConstants;
import com.yichen.serialization.RpcSerialization;
import com.yichen.serialization.SerializationFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 15:47
 * @describe  自定义解码器
 */
public class MiniDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 如果 缓冲区中的数据小于最小字节数，则失败等待。
        if(in.readableBytes()< ProtocolConstants.HEADER_TOTAL_LEN){
            return ;
        }
        // 标记读坐标 可用来回退
        in.markReaderIndex();
        short magic=in.readShort();
        // 判断魔术值，如果不是自定义协议的魔术值，则报异常
        if(magic!=ProtocolConstants.MAGIC){
            throw new IllegalArgumentException("magic number is illegal, " + magic);
        }
        byte version=in.readByte();
        byte serialization=in.readByte();
        byte type=in.readByte();
        byte status=in.readByte();
        long requestId=in.readLong();
        int size=in.readInt();
        // 如果数据内容还没有接收全，则退出等待
        if(in.readableBytes()<size){
            in.resetReaderIndex();
            return;
        }
        // 读取 数据内容
        byte[] data = new byte[size];
        in.readBytes(data);
        // 查看消息类型
        MsgType msgTypeEnum = MsgType.findByType(type);
        if (msgTypeEnum == null) {
            return;
        }
        // 构造 header
        MsgHeader header=new MsgHeader();
        header.setSerialization(serialization);
        header.setMagic(magic);
        header.setRequestId(requestId);
        header.setStatus(status);
        header.setMsgType(type);
        header.setVersion(version);
        header.setMsgLen(size);
        // 根据具体的消息类型 构造body
        RpcSerialization rpcSerialization= SerializationFactory.getRpcSerialization(serialization);
        switch (msgTypeEnum){
            case REQUEST:
                // 反序列化请求体内容
                MiniRequest request=rpcSerialization.deserialize(data,MiniRequest.class);
                if(request!=null){
                    MiniProtocol<MiniRequest> protocol=new MiniProtocol<>();
                    protocol.setBody(request);
                    protocol.setHeader(header);
                    out.add(protocol);
                }
                break;
            case RESPONSE:
                // 反序列化相应消息体
                MiniResponse response=rpcSerialization.deserialize(data,MiniResponse.class);
                if(response!=null){
                    MiniProtocol<MiniResponse> protocol=new MiniProtocol<>();
                    protocol.setBody(response);
                    protocol.setHeader(header);
                    out.add(protocol);
                }
                break;
            case HEARTBEAT:
                break;
            default:
                break;
        }
    }
}
