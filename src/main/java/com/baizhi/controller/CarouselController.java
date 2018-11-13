package com.baizhi.controller;



import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
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
@RequestMapping("carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<Carousel> findAll(){
        List<Carousel> carousels = carouselService.findAll();
        return  carousels;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String,Object> date(String id) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            carouselService.date(id);
            result.put("success",true);
            result.put("message","删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("message","删除失败");
        }
        return result;
    }
    @RequestMapping("updates")
    @ResponseBody
    public Map<String,Object> updates(String[] id) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            for (String i: id) {
                carouselService.date(i);
            }
            result.put("success",true);
            result.put("message","删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("message","删除失败");
        }
        return result;
    }
    @RequestMapping("save")
    @ResponseBody
    public Map<String,Object> updates(Carousel carousel, HttpSession session, MultipartFile file) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            // 获取上传路径
            String realPath = session.getServletContext().getRealPath("/back/carousel/img");
           //获取文件名
            carousel.setId(UUID.randomUUID().toString());
            carousel.setPath("back/carousel/img/"+file.getOriginalFilename());
            //添加Carousel
            carouselService.add(carousel);
            //上传文件
            file.transferTo(new File(realPath,file.getOriginalFilename()));
            result.put("success",true);
            result.put("message","添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("message","添加失败");
        }
        return result;
    }
    @RequestMapping("findAllone")
    @ResponseBody
    public Carousel findAllone(String id){
        Carousel carousel = carouselService.findAllone(id);
         return carousel;
    }

    @RequestMapping("date")
    @ResponseBody
    public Map<String,Object> date(Carousel carousel ,HttpSession session,MultipartFile file) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            // 获取上传路径
            String realPath = session.getServletContext().getRealPath("/back/carousel/img");
            //获取文件名
            carousel.setPath("back/carousel/img/"+file.getOriginalFilename());
            carouselService.update(carousel);
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
