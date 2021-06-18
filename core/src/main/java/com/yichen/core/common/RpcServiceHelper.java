package com.yichen.core.common;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 10:52
 * @describe  构造 注册的 服务key
 */
public class RpcServiceHelper {
    public static String buildServiceKey(String serviceName, String serviceVersion) {
        return String.join("#", serviceName, serviceVersion);
    }
}
