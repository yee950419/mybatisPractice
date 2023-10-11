package com.study.mybatis.music.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Album {

    private Long id;
    private String albumName;
    private String author;
}
