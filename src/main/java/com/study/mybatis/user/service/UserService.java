package com.study.mybatis.user.service;

import com.study.mybatis.user.dto.UserFindOneDto;
import com.study.mybatis.user.dto.UserRegistDto;
import com.study.mybatis.user.dto.UserUpdateDto;

import java.util.List;

public interface UserService {

    int registUser(UserRegistDto userRegistDto);

    UserFindOneDto findUser(Long id);

    int updateUser(UserUpdateDto userUpdateDto);

    List<UserFindOneDto> findAll();

    int deleteUser(Long id);
}
