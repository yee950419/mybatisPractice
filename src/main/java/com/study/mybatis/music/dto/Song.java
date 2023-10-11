package com.study.mybatis.music.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Song {

    private Long id;
    private Long albumId;
    private String songName;
}
