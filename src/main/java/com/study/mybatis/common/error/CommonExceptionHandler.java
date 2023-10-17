package com.study.mybatis.common.error;

import com.study.mybatis.common.responsemessage.ResponseFailMessage;
import com.study.mybatis.music.error.MusicException;
import com.study.mybatis.user.error.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = {MusicException.class})
    ResponseEntity<?> musicException(MusicException e) {

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("errorMessage", e.getMessage());

        return ResponseEntity.badRequest().body(new ResponseFailMessage(HttpStatus.BAD_REQUEST, responseMap));
    }

    @ExceptionHandler(value = {UserException.class})
    ResponseEntity<?> userException(UserException e) {

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("errorMessage", e.getMessage());

        return ResponseEntity.badRequest().body(new ResponseFailMessage(HttpStatus.BAD_REQUEST, responseMap));
    }
}
