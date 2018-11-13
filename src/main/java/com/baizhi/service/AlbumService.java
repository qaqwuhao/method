package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {

    List<Album> findAll(Integer page, Integer rows);
    Long findTotals();
    void save(Album album);
}
