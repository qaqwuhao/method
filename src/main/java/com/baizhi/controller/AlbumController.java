package com.baizhi.controller;


import com.baizhi.entity.Album;
import com.baizhi.entity.Guru;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        List<Album> all = albumService.findAll(page, rows);

        Long totals = albumService.findTotals();
        results.put("total",totals);
        results.put("rows",all);
        return results;
    }
    //添加
    @RequestMapping("/albumsave")
    @ResponseBody
    public Map<String,Object> save(Album album, HttpSession session, MultipartFile file){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            // 获取上传路径
            String realPath = session.getServletContext().getRealPath("/back/album/img");
            //获取文件名
            album.setId(UUID.randomUUID().toString());
            album.setPictre("back/album/img/"+file.getOriginalFilename());
            album.setDate(new Date());
            albumService.save(album);
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
}
