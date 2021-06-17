package com.yichen.serialization;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/6/17 15:41
 * @describe  序列化异常类
 */
public class SerializationException extends RuntimeException {

    private static final long serialVersionUID = 3365624081242234230L;

    public SerializationException() {
        super();
    }

    public SerializationException(String msg) {
        super(msg);
    }

    public SerializationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public SerializationException(Throwable cause) {
        super(cause);
    }
}
