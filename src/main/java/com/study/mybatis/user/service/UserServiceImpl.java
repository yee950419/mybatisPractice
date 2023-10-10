package com.study.mybatis.user.service;

import com.study.mybatis.user.dto.UserFindOneDto;
import com.study.mybatis.user.dto.UserRegistDto;
import com.study.mybatis.user.dto.UserUpdateDto;
import com.study.mybatis.user.error.UserException;
import com.study.mybatis.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;

    @Override
    public UserFindOneDto findUser(Long id) {

        UserFindOneDto result = mapper.findUser(id);

        return result;
    }

    @Override
    public int updateUser(UserUpdateDto userUpdateDto) {
        return 0;
    }

    @Override
    public List<UserFindOneDto> findAll() {

        List<UserFindOneDto> resultList = mapper.findAll();

        return resultList;
    }

    @Override
    @Transactional
    public int registUser(UserRegistDto userRegistDto) {


        try {

            int result = mapper.registUser(userRegistDto);

            return result;
        }
        catch(Exception e) {
            throw new UserException("등록 에러");
        }


    }
}