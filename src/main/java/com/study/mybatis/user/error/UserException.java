package com.study.mybatis.user.error;

public class UserException extends RuntimeException {

    public UserException() {}

    public UserException(String msg) {
        super(msg);
    }
}
