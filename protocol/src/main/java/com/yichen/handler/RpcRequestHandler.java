package com.yichen.handler;

import com.yichen.core.common.MiniRequest;
import com.yichen.core.common.MiniResponse;
import com.yichen.core.common.RpcServiceHelper;
import com.yichen.protocol.MiniProtocol;
import com.yichen.protocol.MsgHeader;
import com.yichen.protocol.MsgStatus;
import com.yichen.protocol.MsgType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.reflect.FastClass;

import java.util.Map;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 13:44
 * @describe  自定义 handler 用来处理 request请求
 */
@Slf4j
public class RpcRequestHandler extends SimpleChannelInboundHandler<MiniProtocol<MiniRequest>> {

    private final Map<String, Object> rpcServiceMap;

    public RpcRequestHandler(Map<String, Object> rpcServiceMap) {
        this.rpcServiceMap = rpcServiceMap;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MiniProtocol<MiniRequest> protocol) throws Exception {
        RpcRequestProcessor.submitRequest(() -> {
            MiniProtocol<MiniResponse> resProtocol = new MiniProtocol<>();
            MiniResponse response = new MiniResponse();
            MsgHeader header = protocol.getHeader();
            header.setMsgType((byte) MsgType.RESPONSE.getCode());
            try {
                Object result = handle(protocol.getBody());
                response.setData(result);

                header.setStatus((byte) MsgStatus.SUCCESS.getCode());
                resProtocol.setHeader(header);
                resProtocol.setBody(response);
            } catch (Throwable throwable) {
                header.setStatus((byte) MsgStatus.FAIL.getCode());
                response.setErrorMsg(throwable.toString());
                log.error("process request {} error", header.getRequestId(), throwable);
            }
            ctx.writeAndFlush(resProtocol);
        });
    }
    private Object handle(MiniRequest request) throws Throwable {
        String serviceKey = RpcServiceHelper.buildServiceKey(request.getClassName(), request.getServiceVersion());
        Object serviceBean = rpcServiceMap.get(serviceKey);

        if (serviceBean == null) {
            throw new RuntimeException(String.format("service not exist: %s:%s", request.getClassName(), request.getMethodName()));
        }

        Class<?> serviceClass = serviceBean.getClass();
        String methodName = request.getMethodName();
        Class<?>[] parameterTypes = request.getParameterTypes();
        Object[] parameters = request.getParams();

        FastClass fastClass = FastClass.create(serviceClass);
        int methodIndex = fastClass.getIndex(methodName, parameterTypes);
        return fastClass.invoke(methodIndex, serviceBean, parameters);
    }


}
