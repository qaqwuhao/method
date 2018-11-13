package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {
    //查
    List<T> findAll();
     //增
    void add(T t);
    //删
    void delete(String id);
    //改
    void update(T t);
    //根据id查
    T findAllone(String id);
    //登陆
    T login(T t);
    //分页查询
    List<T> findByPage(@Param("start") Integer start,
                         @Param("rows") Integer rows);
    Long findTotals();
}
