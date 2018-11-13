package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



//文章表
public class Artcle {

    private String id;
//    文章名
     private String name;
//   发表时间
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @JsonFormat(pattern ="yyyy-mm-dd")
    private Date date;
//     文章图片
    private String picture;
//     文章内容
    private String txt;
//      扩展字段
    private String ext;
//      插图
    private String stration;

    @Override
    public String toString() {
        return "Artcle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", picture='" + picture + '\'' +
                ", txt='" + txt + '\'' +
                ", ext='" + ext + '\'' +
                ", stration='" + stration + '\'' +
                '}';
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getStration() {
        return stration;
    }

    public void setStration(String stration) {
        this.stration = stration;
    }

    public Artcle(String id, String name, Date date, String picture, String txt, String ext, String stration) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.picture = picture;
        this.txt = txt;
        this.ext = ext;
        this.stration = stration;
    }

    public Artcle() {
    }
}
