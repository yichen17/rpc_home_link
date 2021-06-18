package com.yichen.core.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 11:07
 */
@Data
@ConfigurationProperties(prefix = "rpc")
public class RpcProperties {
    /**
     * 服务端口
     */
    private int servicePort;
    /**
     * 服务地址
     */
    private String registerAddr;
    /**
     * 服务注册类型
     */
    private String registerType;

}
