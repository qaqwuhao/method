package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumDao albumDao;


    public List<Album> findAll(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Album> byPage = albumDao.findByPage(start, rows);
        for (Album album: byPage) {
            album.setNumber(album.getChildren().size()+"");
        }
        return byPage;
    }

    @Override
    public Long findTotals() {
        Long totals = albumDao.findTotals();
        return totals;
    }

    @Override
    public void save(Album album) {
        albumDao.add(album);
    }
}
