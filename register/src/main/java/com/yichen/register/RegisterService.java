package com.yichen.register;

import com.yichen.core.common.ServiceMeta;

import java.io.IOException;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 10:25
 * @describe 注册服务必须实现的接口
 */
public interface RegisterService {
    /**
     * 服务注册
     * @param serviceMeta  注册的源信息
     * @throws Exception 注册失败的异常信息
     */
    void register(ServiceMeta serviceMeta) throws Exception;

    /**
     * 服务注销
     * @param serviceMeta 注销的源信息
     * @throws Exception  注销失败的异常信息
     */
    void unRegister(ServiceMeta serviceMeta) throws Exception;

    /**
     * 服务发现
     * @param serviceName 服务名称
     * @param invokerHashCode  客户端 hash 值
     * @return 返回服务名称和hash 值对应的 节点源信息
     * @throws Exception  执行的异常结果
     */
    ServiceMeta discovery(String serviceName, int invokerHashCode) throws Exception;

    /**
     * 注册中心销毁
     * @throws IOException  执行失败的异常信息
     */
    void destroy() throws IOException;

}
