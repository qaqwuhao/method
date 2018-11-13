package com.baizhi.service;

import com.baizhi.dao.ArtcleDao;
import com.baizhi.entity.Artcle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArtcleServiceImpl implements ArtcleService{

    @Autowired
    private ArtcleDao artcleDao;

    @Override
    public List<Artcle> findAll(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Artcle> byPage = artcleDao.findByPage(start, rows);
        return byPage;
    }

    @Override
    public Long findTotals() {
        Long totals = artcleDao.findTotals();
        return totals;
    }
}
