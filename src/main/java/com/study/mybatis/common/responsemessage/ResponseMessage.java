package com.study.mybatis.common.responsemessage;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class ResponseMessage {

    private HttpStatus httpStatus;
    private String message;
    private Map<String, Object> results;

    public ResponseMessage(HttpStatus httpStatus, String message, Map<String, Object> results) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.results = results;
    }
}
