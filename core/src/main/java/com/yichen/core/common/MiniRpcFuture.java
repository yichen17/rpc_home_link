package com.yichen.core.common;

import io.netty.util.concurrent.Promise;
import lombok.Data;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 11:12
 * @describe  rpc 远程调用返回  自定义 promise
 */
@Data
public class MiniRpcFuture<T> {
    private Promise<T> promise;
    private long timeout;

    public MiniRpcFuture(Promise<T> promise, long timeout) {
        this.promise = promise;
        this.timeout = timeout;
    }
}
