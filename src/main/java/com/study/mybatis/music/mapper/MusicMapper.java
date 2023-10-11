package com.study.mybatis.music.mapper;

import com.study.mybatis.music.dto.MusicRegistAlbumDto;
import com.study.mybatis.music.dto.MusicRegistSongDto;
import com.study.mybatis.music.dto.ShowAlbumAndSongListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicMapper {

    int registAlbum(MusicRegistAlbumDto musicRegistAlbumDto);

    int registSong(MusicRegistSongDto musicRegistSongDto);

    List<ShowAlbumAndSongListDto> showAllAlbumAndSong();
}
