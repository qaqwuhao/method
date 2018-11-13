package com.baizhi.service;


import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuruServiceImpl implements GuruService{

    @Autowired
    private GuruDao guruDao;

    @Override
    public List<Guru> findAll() {
        List<Guru> gurus = guruDao.findAll();
        return gurus;
    }

    @Override
    public List<Guru> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Guru> Gurus = guruDao.findByPage(start, rows);
        return Gurus;
    }

    @Override
    public Long findTotals() {
        Long totals = guruDao.findTotals();
        return totals;
    }

    @Override
    public void delete(String id) {
        guruDao.delete(id);
    }

    @Override
    public void add(Guru guru) {
        guruDao.add(guru);
    }

    @Override
    public Guru findAllone(String id) {
        Guru guru = guruDao.findAllone(id);
        return guru;
    }

    @Override
    public void update(Guru guru) {
        guruDao.update(guru);
    }
}
