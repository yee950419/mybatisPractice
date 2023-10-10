package com.study.mybatis.user.service;

import com.study.mybatis.user.dto.UserFindOneDto;
import com.study.mybatis.user.dto.UserRegistDto;
import com.study.mybatis.user.dto.UserUpdateDto;
import com.study.mybatis.user.error.UserException;
import com.study.mybatis.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;

    @Override
    public UserFindOneDto findUser(Long id) {

        try{
            UserFindOneDto result = mapper.findUser(id);

            if(result == null) {
                throw new UserException("해당하는 회원이 없습니다.");
            }
            return result;
        }
        catch(Exception e){
            throw new UserException("회원 조회 에러");
        }
    }

    @Override
    public List<UserFindOneDto> findAll() {

        try{
            List<UserFindOneDto> resultList = mapper.findAll();

            if(resultList.size() == 0){
                throw new UserException("회원이 존재하지 않습니다.");
            }
            return resultList;
        }
        catch(Exception e) {
            throw new UserException("회원 리스트 조회 에러");
        }

    }

    @Override
    @Transactional
    public int updateUser(UserUpdateDto userUpdateDto) {

        try{
            int result = mapper.updateUser(userUpdateDto);
            if(result == 0) {
                throw new UserException("수정된 회원이 없습니다.");
            }
            return result;
        }
        catch(Exception e){
            throw new UserException("회원 수정 오류");
        }
    }

    @Override
    @Transactional
    public int registUser(UserRegistDto userRegistDto) {


        try {
            int result = mapper.registUser(userRegistDto);

            if(result == 0){
                throw new UserException("수정된 내역이 없습니다.");
            }
            return result;
        }
        catch(Exception e) {
            throw new UserException("회원 등록 에러");
        }
    }

    @Override
    @Transactional
    public int deleteUser(Long id) {

        try{
            int result = mapper.deleteUser(id);
            if(result == 0) {
                throw new UserException("삭제된 내역이 없습니다.");
            }
            return result;
        }
        catch (Exception e) {
            throw new UserException("회원 삭제 에러");
        }
    }
}