package com.baizhi.service;

import com.baizhi.dao.AdministratorDao;
import com.baizhi.entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdministratorServiceImpl implements AdministratorService{

    @Autowired
    private AdministratorDao administratorDao;



    public Administrator login(Administrator administrator) {
        Administrator login = administratorDao.login(administrator);
       return login;
    }

//   查一个
    public Administrator findAllone(String id) {
        Administrator allone = administratorDao.findAllone(id);
        return allone;
    }

//    修改
    public void update(Administrator administrator) {
        administratorDao.update(administrator);
    }
}
