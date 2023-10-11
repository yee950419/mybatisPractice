package com.study.mybatis.music.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShowSongAndDetailDto {

    private Long id;
    private Long albumId;
    private String songName;
    private String createAt;
}
