package com.baizhi.controller;


import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;



    @RequestMapping("findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        List<Course> all = courseService.findAll(page, rows);
        Long totals = courseService.findTotals();
        results.put("total",totals);
        results.put("rows",all);
        return results;
    }
}
