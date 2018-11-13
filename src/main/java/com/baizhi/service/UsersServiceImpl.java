package com.baizhi.service;

import com.baizhi.dao.UsersDao;
import com.baizhi.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<Users> findAll() {
        List<Users> users = usersDao.findAll();
        return users;
    }

    @Override
    public List<Users> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Users> users = usersDao.findByPage(start, rows);
        return users;
    }

    @Override
    public Long findTotals() {
        Long totals = usersDao.findTotals();
        return totals;
    }



    @Override
    public void update(Users users) {

        usersDao.update(users);

    }

    @Override
    public void add(Users users) {
        usersDao.add(users);
    }

    @Override
    public Users findone(String id) {
        Users allone = usersDao.findAllone(id);
        return allone;
    }

    @Override
    public Boolean login(Users users) {
        Users login = usersDao.login(users);
        if(login!=null){
            return true;
        }else{
            return false;
        }
    }
}
