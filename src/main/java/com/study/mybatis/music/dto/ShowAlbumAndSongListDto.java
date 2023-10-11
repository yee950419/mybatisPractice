package com.study.mybatis.music.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShowAlbumAndSongListDto {

//    private Long id;
    private String albumName;
    private String author;
    private List<Song> songList;
}
