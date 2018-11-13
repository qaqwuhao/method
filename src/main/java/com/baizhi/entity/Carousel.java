package com.baizhi.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//首页轮换图片
public class Carousel {
    private String id;
    //名称
    private String name;
    //图片路径
    private String path;
    //时间
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @JsonFormat(pattern ="yyyy-mm-dd")
    private Date date;
    //描述
    private String desc;
    //状态
    private String status;

    public Carousel() {
    }

    public Carousel(String id, String name, String path, Date date, String desc, String status) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.date = date;
        this.desc = desc;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", date=" + date +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
