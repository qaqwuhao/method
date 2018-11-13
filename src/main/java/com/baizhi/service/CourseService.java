package com.baizhi.service;



import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll(Integer page, Integer rows);
    Long findTotals();
}
