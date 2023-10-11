package com.study.mybatis.music.service;

import com.study.mybatis.music.dto.*;
import com.study.mybatis.music.error.MusicException;
import com.study.mybatis.music.mapper.MusicMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MusicServiceImpl implements MusicService {

    private final MusicMapper mapper;

    @Override
    @Transactional
    public int registAlbum(MusicRegistAlbumDto musicRegistAlbumDto) {

        try{
            int result = mapper.registAlbum(musicRegistAlbumDto);

            return result;
        }
        catch(Exception e){
            throw new MusicException("앨범 등록 에러");
        }
    }

    @Override
    public int registSong(MusicRegistSongDto musicRegistSongDto) {

        try{
            int result = mapper.registSong(musicRegistSongDto);

            return result;
        }
        catch(Exception e) {
            throw new MusicException("노래 등록 에러");
        }
    }

    @Override
    public List<ShowAlbumAndSongListDto> showAllAlbumAndSong() {

        try{
            List<ShowAlbumAndSongListDto> resultList = mapper.showAllAlbumAndSong();
            return resultList;
        }
        catch (Exception e) {
            throw new MusicException("앨범, 노래 리스트 조회 에러");
        }
    }

    @Override
    public int registSongInfo(MusicRegistSongInfoDto musicRegistSongInfoDto) {

        try{
            int result = mapper.registSongInfo(musicRegistSongInfoDto);
            return result;
        }
        catch (Exception e) {
            throw new MusicException("노래 상세정보 등록 에러");
        }
    }

    @Override
    public ShowSongAndDetailDto showSongAndInfo(Long id) {

        try {
            ShowSongAndDetailDto result = mapper.showSongAndInfo(id);
            return result;
        }
        catch (Exception e) {
            throw new MusicException("노래 및 상세정보 조회 에러");
        }
    }
}
