package com.yichen.register;

import com.yichen.core.common.ServiceMeta;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 10:31
 * @describe  eureka 实现注册服务
 */
public class EurekaRegisterService implements RegisterService {

    public EurekaRegisterService(String registryAddr) {
        // TODO
    }

    @Override
    public void register(ServiceMeta serviceMeta) {

    }

    @Override
    public void unRegister(ServiceMeta serviceMeta) {

    }

    @Override
    public ServiceMeta discovery(String serviceName, int invokerHashCode) {
        return null;
    }

    @Override
    public void destroy() {

    }
}
