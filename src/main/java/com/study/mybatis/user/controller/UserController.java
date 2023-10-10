package com.study.mybatis.user.controller;

import com.study.mybatis.user.dto.UserFindOneDto;
import com.study.mybatis.user.dto.UserRegistDto;
import com.study.mybatis.user.dto.UserUpdateDto;
import com.study.mybatis.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserFindOneDto findUser(@PathVariable Long id) {

        UserFindOneDto result = userService.findUser(id);

        return result;
    }

    @GetMapping("")
    public List<UserFindOneDto> findAll() {

        List<UserFindOneDto> resultList = userService.findAll();

        return resultList;
    }

    @PostMapping("")
    public int registUser(@RequestBody UserRegistDto userRegistDto) {

        int result = userService.registUser(userRegistDto);

        return result;
    }

    @PatchMapping("")
    public int updateUser(@RequestBody UserUpdateDto userUpdateDto) {

        int result = userService.updateUser(userUpdateDto);

        return result;
    }

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable Long id) {

        int result = userService.deleteUser(id);

        return result;
    }
}
