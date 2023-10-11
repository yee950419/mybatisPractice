package com.study.mybatis.music.controller;

import com.study.mybatis.music.dto.*;
import com.study.mybatis.music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/music")
public class MusicController {

    private final MusicService musicService;

    @GetMapping("/album")
    public List<ShowAlbumAndSongListDto> showAllAlbumAndSong() {
        List<ShowAlbumAndSongListDto> resultList = musicService.showAllAlbumAndSong();

        return resultList;
    }

    @GetMapping("/song/{id}")
    public ShowSongAndDetailDto showSongAndInfo(@PathVariable Long id) {

        ShowSongAndDetailDto result = musicService.showSongAndInfo(id);

        return result;
    }

    @PostMapping("/album")
    public int registAlbum(@RequestBody MusicRegistAlbumDto musicRegistAlbumDto) {

        int result = musicService.registAlbum(musicRegistAlbumDto);

        return result;
    }

    @PostMapping("/song")
    public int registSong(@RequestBody MusicRegistSongDto musicRegistSongDto) {

        int result = musicService.registSong(musicRegistSongDto);

        return result;
    }

    @PostMapping("/song_info")
    public int registSongInfo(@RequestBody MusicRegistSongInfoDto musicRegistSongInfoDto) {

        int result = musicService.registSongInfo(musicRegistSongInfoDto);

        return result;
    }
}
