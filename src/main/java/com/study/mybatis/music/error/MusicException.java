package com.study.mybatis.music.error;

public class MusicException extends RuntimeException {

    public MusicException(){}

    public MusicException(String msg) {
        super(msg);
    }
}
