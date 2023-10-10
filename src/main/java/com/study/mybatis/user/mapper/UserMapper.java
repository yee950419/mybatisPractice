package com.study.mybatis.user.mapper;

import com.study.mybatis.user.dto.UserFindOneDto;
import com.study.mybatis.user.dto.UserRegistDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface UserMapper {

    int registUser(UserRegistDto userRegistDto);

    UserFindOneDto findUser(Long id);

    List<UserFindOneDto> findAll();
}
