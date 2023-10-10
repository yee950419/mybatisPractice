package com.study.mybatis.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class UserFindOneDto {

    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String email;
    private Timestamp joinAt;

}
