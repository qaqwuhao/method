package com.baizhi.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

//专辑表
public class Album {
    private String id;
    //    名称
    private String name;
    //    作者
    private String author;
    //    播音
    private String broadcast;
    //    集数
    private String number;
    //    内容简介

    private String content;
    //    发布时间
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @JsonFormat(pattern ="yyyy-mm-dd")
    private Date date;
    //    图片路径
    private String pictre;
    //      状态
    private String score;
    //星级
    private String star;
    //一张专辑有多张章节
    private List<Section>children;

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", number='" + number + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", pictre='" + pictre + '\'' +
                ", score='" + score + '\'' +
                ", star='" + star + '\'' +
                ", children=" + children +
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPictre() {
        return pictre;
    }

    public void setPictre(String pictre) {
        this.pictre = pictre;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public List<Section> getChildren() {
        return children;
    }

    public void setChildren(List<Section> children) {
        this.children = children;
    }

    public Album(String id, String name, String author, String broadcast, String number, String content, Date date, String pictre, String score, String star, List<Section> children) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.broadcast = broadcast;
        this.number = number;
        this.content = content;
        this.date = date;
        this.pictre = pictre;
        this.score = score;
        this.star = star;
        this.children = children;
    }

    public Album() {
    }
}