package com.study.mybatis.music;

import com.study.mybatis.music.dto.MusicRegistAlbumDto;
import com.study.mybatis.music.dto.MusicRegistSongDto;
import com.study.mybatis.music.dto.ShowAlbumAndSongListDto;
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
}
