package com.example;

/*
 * - 自定义异常
 * - 通常定义一个BaseException，然后派生出各种业务类型异常
 * - BaseException需要从一个合适的Exception派生，建议从RuntimeException开始
 */
public class BaseException extends RuntimeException {
    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}