package com.yichen.handler;

import com.yichen.core.common.MiniResponse;
import com.yichen.core.common.MiniRpcFuture;
import com.yichen.core.common.MiniRpcRequestHolder;
import com.yichen.protocol.MiniProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 13:47
 * @describe 自定义handler 用来处理response
 */
public class RpcResponseHandler extends SimpleChannelInboundHandler<MiniProtocol<MiniResponse>> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MiniProtocol<MiniResponse> msg) {
        long requestId = msg.getHeader().getRequestId();
        MiniRpcFuture<MiniResponse> future = MiniRpcRequestHolder.REQUEST_MAP.remove(requestId);
        future.getPromise().setSuccess(msg.getBody());
    }
}
