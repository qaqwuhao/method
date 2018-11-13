package com.baizhi.service;

import com.baizhi.entity.Users;

import java.util.List;

public interface UsersService {
    List<Users> findAll();
    /* 分页查 */
    List<Users> findByPage(Integer page, Integer rows);

    Long findTotals();

//    更改
    void update(Users users);
//    添加
    void add(Users users);
//    根据id查
    Users findone(String id);
//    登陆
    Boolean login(Users users);
}
