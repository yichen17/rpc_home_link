package com.yichen.core.common;

import lombok.Data;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 10:26
 * @describe  服务注册的源信息
 */
@Data
public class ServiceMeta {
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 服务版本号
     */
    private String serviceVersion;
    /**
     * 服务地址
     */
    private String serviceAddr;
    /**
     * 服务端口号
     */
    private int servicePort;

}
