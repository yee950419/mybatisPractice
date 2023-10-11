package com.study.mybatis.music.service;

import com.study.mybatis.music.dto.MusicRegistAlbumDto;
import com.study.mybatis.music.dto.MusicRegistSongDto;
import com.study.mybatis.music.dto.ShowAlbumAndSongListDto;

import java.util.List;

public interface MusicService {

    int registAlbum(MusicRegistAlbumDto musicRegistAlbumDto);

    int registSong(MusicRegistSongDto musicRegistSongDto);

    List<ShowAlbumAndSongListDto> showAllAlbumAndSong();
}
