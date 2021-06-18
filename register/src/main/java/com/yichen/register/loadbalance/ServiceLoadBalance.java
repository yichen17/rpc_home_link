package com.yichen.register.loadbalance;

import java.util.List;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/18 10:44
 * @describe  负载均衡 接口类
 */
public interface ServiceLoadBalance<T> {
    /**
     *  根据hash 值从 服务集合中选取
     * @param servers  服务集合
     * @param hashCode  hash 值
     * @return
     */
    T select(List<T> servers, int hashCode);
}
