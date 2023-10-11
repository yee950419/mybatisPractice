package com.study.mybatis.music.service;

import com.study.mybatis.music.dto.*;

import java.util.List;

public interface MusicService {

    int registAlbum(MusicRegistAlbumDto musicRegistAlbumDto);

    int registSong(MusicRegistSongDto musicRegistSongDto);

    List<ShowAlbumAndSongListDto> showAllAlbumAndSong();

    int registSongInfo(MusicRegistSongInfoDto musicRegistSongInfoDto);

    ShowSongAndDetailDto showSongAndInfo(Long id);
}
