package com.study.mybatis.music.controller;

import com.study.mybatis.common.responsemessage.ResponseMessage;
import com.study.mybatis.music.dto.*;
import com.study.mybatis.music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/music")
public class MusicController {

    private final MusicService musicService;

    @GetMapping("/album")
    public ResponseEntity<?> showAllAlbumAndSong() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        List<ShowAlbumAndSongListDto> resultList = musicService.showAllAlbumAndSong();
        responseMap.put("result", resultList);

        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.OK, "모든 앨범, 노래 조회 성공", responseMap));
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<?> showSongAndInfo(@PathVariable Long id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        ShowSongAndDetailDto result = musicService.showSongAndInfo(id);
        responseMap.put("result", result);

        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.OK, "노래 조회 성공", responseMap));
    }

    @PostMapping("/album")
    public ResponseEntity<?> registAlbum(@RequestBody MusicRegistAlbumDto musicRegistAlbumDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        int result = musicService.registAlbum(musicRegistAlbumDto);
        responseMap.put("result", result);

        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.CREATED, "앨범 등록 성공", responseMap));
    }

    @PostMapping("/song")
    public ResponseEntity<?> registSong(@RequestBody MusicRegistSongDto musicRegistSongDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        int result = musicService.registSong(musicRegistSongDto);
        responseMap.put("result", result);

        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.CREATED, "노래 등록 성공", responseMap));
    }

    @PostMapping("/song_info")
    public ResponseEntity<?> registSongInfo(@RequestBody MusicRegistSongInfoDto musicRegistSongInfoDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        int result = musicService.registSongInfo(musicRegistSongInfoDto);

        responseMap.put("result", result);

        return ResponseEntity.ok().body(new ResponseMessage(HttpStatus.CREATED, "노래 세부정보 등록 성공", responseMap));
    }
}
