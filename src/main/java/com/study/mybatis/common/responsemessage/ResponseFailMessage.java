package com.study.mybatis.common.responsemessage;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class ResponseFailMessage {

    private HttpStatus httpStatus;
    private Map<String, Object> results;

    public ResponseFailMessage(HttpStatus httpStatus, Map<String, Object> results) {
        this.httpStatus = httpStatus;
        this.results = results;
    }
}
