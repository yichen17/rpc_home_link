package com.yichen.provider;

import com.yichen.core.common.RpcProperties;
import com.yichen.register.RegisterFactory;
import com.yichen.register.RegisterService;
import com.yichen.register.RegisterType;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 11:32
 * @describe rpc provider 自动注册
 */
@Configuration
@EnableConfigurationProperties(RpcProperties.class)
public class RpcProviderAutoConfiguration {
    @Resource
    private RpcProperties properties;

    @Bean
    public RpcProvider init() throws Exception {
        RegisterType type = RegisterType.valueOf(properties.getRegisterType());
        RegisterService registerService = RegisterFactory.getRegisterService(properties.getRegisterAddr(), type);
        return new RpcProvider(properties.getServicePort(), registerService);
    }

}
