package com.baizhi.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    /**
     *
     * 	文件下载:
     * 	   1.默认下载时 浏览器会根据下载的内容自动打开 如果不能打开则下载
     *     2.如果需要指定文件以附件形式下载 设置响应头信息
     *     	attachment;  以附件形式下载
     *      inline    ;  在线打开
     *     	response.setHeader("content-disposition", "attachment;fileName="+URLEncoder.encode(fileName, "UTF-8"));
     */
 @RequestMapping("/download")
 public void download(String fileName, String openStyle, HttpServletRequest request, HttpServletResponse response) throws Exception {
     //1.根据接收的文件名去服务中指定目录读取文件
     String realPath = request.getSession().getServletContext().getRealPath("/back/album/mp3");
     String filenames[] = fileName.toString().split("/");
     String filename = filenames[filenames.length-1];
     //2.以文件输入流读取文件
     FileInputStream is = new FileInputStream(new File(realPath, filename));
     //2.1 设置响应头
     response.setHeader("content-disposition", openStyle+";fileName=" + URLEncoder.encode(fileName, "UTF-8"));
     //3.获取响应输出流
     ServletOutputStream os = response.getOutputStream();
     //4.使用IOUtils工具类
     IOUtils.copy(is, os);
     //5.关流
     IOUtils.closeQuietly(is);//安静关流
     IOUtils.closeQuietly(os);

 }
}
