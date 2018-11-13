package com.baizhi.service;

import com.baizhi.entity.Administrator;

public interface AdministratorService {

    Administrator login(Administrator administrator);
    Administrator findAllone(String id);
    void update(Administrator administrator);
}
