package com.yichen.core.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 11:14
 * @describe 缓存客户端请求的 执行 promise ，供客户端的 future 请求。
 */
public class MiniRpcRequestHolder {

    public final static AtomicLong REQUEST_ID_GEN = new AtomicLong(0);

    public static final Map<Long, MiniRpcFuture<MiniResponse>> REQUEST_MAP = new ConcurrentHashMap<>();
}