package com.study.mybatis.user.controller;

import com.study.mybatis.common.responsemessage.ResponseMessage;
import com.study.mybatis.user.dto.UserFindOneDto;
import com.study.mybatis.user.dto.UserRegistDto;
import com.study.mybatis.user.dto.UserUpdateDto;
import com.study.mybatis.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findUser(@PathVariable Long id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        UserFindOneDto result = userService.findUser(id);
        responseMap.put("result", result);

        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.OK, "유저 조회 성공", responseMap));
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        List<UserFindOneDto> resultList = userService.findAll();
        responseMap.put("result", resultList);

        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.OK, "모든 유저 조회 성공", responseMap));
    }

    @PostMapping("")
    public ResponseEntity<?> registUser(@RequestBody UserRegistDto userRegistDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        int result = userService.registUser(userRegistDto);
        responseMap.put("result", result);

        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.CREATED, "유저 등록 성공", responseMap));
    }

    @PatchMapping("")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateDto userUpdateDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        int result = userService.updateUser(userUpdateDto);
        responseMap.put("result", result);

        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.OK, "유저 정보 수정 성공", responseMap));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        int result = userService.deleteUser(id);
        responseMap.put("result", result);

        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.OK, "유저 삭제 성공", responseMap));
    }
}
