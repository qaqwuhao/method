package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    List<Guru> findAll();
    /* 分页查 */
    List<Guru> findByPage(Integer page,Integer rows);

    Long findTotals();
    //删除
    void delete(String id);
    void add(Guru guru);
    //根据id查
    Guru findAllone(String id);
//    修改
    void update(Guru guru);
}
