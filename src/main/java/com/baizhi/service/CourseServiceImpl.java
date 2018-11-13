package com.baizhi.service;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> findAll(Integer page, Integer rows) {
        int start = (page-1)*rows;
        List<Course> byPage = courseDao.findByPage(start, rows);
        return byPage;
    }

    @Override
    public Long findTotals() {
        Long totals = courseDao.findTotals();
        return totals;
    }
}
