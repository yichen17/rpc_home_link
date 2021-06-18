package com.yichen.core.common;

import lombok.Data;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 14:57
 * @describe  相应结果   存在两种请求，请求成功和请求失败。 两种状态区别由消息头中的status 辨别。
 */
@Data
public class MiniResponse {
    /**
     * 请求结果
     */
    private Object data;
    /**
     * 错误内容
     */
    private String errorMsg;

}
