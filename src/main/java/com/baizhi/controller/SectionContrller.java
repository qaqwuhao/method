package com.baizhi.controller;


import com.baizhi.entity.Section;
import com.baizhi.service.SectionService;
import com.baizhi.utils.DurationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("section")
public class SectionContrller{

    @Autowired
    private SectionService sectionService;

    @RequestMapping("add")
    @ResponseBody
    public Map<String,Object> save(Section section, HttpSession session, MultipartFile addFile) {
        Map<String, Object> results = new HashMap<String, Object>();
        try{
            // 获取上传路径
            String realPath = session.getServletContext().getRealPath("/back/album/mp3");
            //上传文件

            addFile.transferTo(new File(realPath,addFile.getOriginalFilename()));
            //获取文件大小时常
            //文件大小
            section.setId(UUID.randomUUID().toString());
            section.setName(addFile.getOriginalFilename());
            section.setDate(new Date());
            long size = addFile.getSize();
            Double d=size/1024.0/1024;  //获取时间
            d = (double)Math.round(d*100)/100;//获取小数点后两位
            String s = d.toString();
            //放入数据库
            section.setSiza(s+"MB");
            section.setDownlad("back/album/mp3/"+addFile.getOriginalFilename());
            File file = new File(realPath, addFile.getOriginalFilename());

            //获取音频长度
            String videoTime = DurationUtil.getVideoTime(file);
            section.setDuration(videoTime);

            sectionService.add(section);
            results.put("success",true);
            results.put("message","添加成功");
        }catch (Exception e){
            e.printStackTrace();
            results.put("success",false);
            results.put("message","添加失败");
        }
        return null;
    }
}
