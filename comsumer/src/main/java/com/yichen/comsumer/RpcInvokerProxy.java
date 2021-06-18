package com.yichen.comsumer;

import com.yichen.core.common.MiniRequest;
import com.yichen.core.common.MiniResponse;
import com.yichen.core.common.MiniRpcFuture;
import com.yichen.core.common.MiniRpcRequestHolder;
import com.yichen.protocol.MiniProtocol;
import com.yichen.protocol.MsgHeader;
import com.yichen.protocol.MsgType;
import com.yichen.protocol.ProtocolConstants;
import com.yichen.register.RegisterService;
import com.yichen.serialization.SerializationTypeEnum;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 14:18
 */
public class RpcInvokerProxy implements InvocationHandler {

    private final String serviceVersion;
    private final long timeout;
    private final RegisterService registerService;

    public RpcInvokerProxy(String serviceVersion, long timeout, RegisterService registerService) {
        this.serviceVersion = serviceVersion;
        this.timeout = timeout;
        this.registerService = registerService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MiniProtocol<MiniRequest> protocol = new MiniProtocol<>();
        MsgHeader header = new MsgHeader();
        long requestId = MiniRpcRequestHolder.REQUEST_ID_GEN.incrementAndGet();
        header.setMagic(ProtocolConstants.MAGIC);
        header.setVersion(ProtocolConstants.VERSION);
        header.setRequestId(requestId);
        header.setSerialization((byte) SerializationTypeEnum.HESSIAN.getType());
        header.setMsgType((byte) MsgType.REQUEST.getCode());
        header.setStatus((byte) 0x1);
        protocol.setHeader(header);

        MiniRequest request = new MiniRequest();
        request.setServiceVersion(this.serviceVersion);
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameterTypes(method.getParameterTypes());
        request.setParams(args);
        protocol.setBody(request);

        RpcConsumer rpcConsumer = new RpcConsumer();
        MiniRpcFuture<MiniResponse> future = new MiniRpcFuture<>(new DefaultPromise<>(new DefaultEventLoop()), timeout);
        MiniRpcRequestHolder.REQUEST_MAP.put(requestId, future);
        rpcConsumer.sendRequest(protocol, this.registerService);

        // TODO hold request by ThreadLocal


        return future.getPromise().get(future.getTimeout(), TimeUnit.MILLISECONDS).getData();
    }
}
