package com.yichen.core.common;

import lombok.Data;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 14:57
 * @describe  请求内容   由于是rpc调用，故需要确定  类.方法(参数类型：参数)：版本 才能最终确定 调用的方法。
 */
@Data
public class MiniRequest {
    /**
     * 服务版本
     */
    private String serviceVersion;
    /**
     * 类名
     */
    private String className;
    /**
     * 方法名称
     */
    private String methodName;
    /**
     * 请求参数
     */
    private Object[]params;
    /**
     * 请求参数类型
     */
    private Class<?>[]parameterTypes;

}
