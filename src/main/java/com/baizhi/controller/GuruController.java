package com.baizhi.controller;


import com.baizhi.entity.Carousel;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("guru")
public class GuruController {

    @Autowired
    private GuruService guruService;


    @RequestMapping("findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        List<Guru> gurus = guruService.findByPage(page, rows);
        Long totals = guruService.findTotals();
        results.put("total",totals);
        results.put("rows",gurus);
        return results;
    }
    @RequestMapping("delete")
    @ResponseBody
    public Map<String,Object> delete(String id){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            guruService.delete(id);
            result.put("success",true);
            result.put("message","删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("message","删除失败");
        }
            return result;
    }
    @RequestMapping("deletes")
    @ResponseBody
    public Map<String,Object> updates(String[] id) {
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            for (String i: id) {
            guruService.delete(i);
            }
            results.put("success",true);
            results.put("message","删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message","删除失败");
        }
        return results;
    }
    @RequestMapping("save")
    @ResponseBody
    public Map<String,Object> add(Guru guru, HttpSession session, MultipartFile file) {
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            // 获取上传路径
            String realPath = session.getServletContext().getRealPath("/back/guru/img");
            //获取文件名
            guru.setId(UUID.randomUUID().toString());
            guru.setHead("back/guru/img/"+file.getOriginalFilename());
            guruService.add(guru);
            //上传文件
            file.transferTo(new File(realPath,file.getOriginalFilename()));

            results.put("success",true);
            results.put("message","添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message","添加失败");
        }
        return results;
    }
    @RequestMapping("findAllone")
    @ResponseBody
    public Guru findAllone(String id){
       Guru guru = guruService.findAllone(id);
       return guru;
    }

    @RequestMapping("date")
    @ResponseBody
    public Map<String,Object> date(Guru guru , HttpSession session, MultipartFile file) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            // 获取上传路径
            String realPath = session.getServletContext().getRealPath("/back/guru/img");
            //获取文件名
            guru.setHead("back/guru/img/"+file.getOriginalFilename());
            guruService.update(guru);
            //上传文件
            file.transferTo(new File(realPath,file.getOriginalFilename()));
            result.put("success",true);
            result.put("message","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("message","修改失败");
        }
        return result;
    }

}
