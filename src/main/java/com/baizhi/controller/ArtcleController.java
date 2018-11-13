package com.baizhi.controller;


import com.baizhi.entity.Artcle;
import com.baizhi.service.ArtcleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Artcle")
public class ArtcleController {

    @Autowired
    private ArtcleService artcleService;

    @RequestMapping("findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();

        List<Artcle> all = artcleService.findAll(page, rows);
        Long totals = artcleService.findTotals();
        results.put("total",totals);
        results.put("rows",all);
        return results;
    }
}
