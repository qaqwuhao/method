package com.baizhi.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//章节表
public class Section {
    private String id;
    //章节名
    private String name;
    //章节大小
    private String siza;
    //下载路径
    private String downlad;
    //持续时常
    private String duration;
    //上传时间
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @JsonFormat(pattern ="yyyy-mm-dd")
    private Date date;
    private String album_id;

    @Override
    public String toString() {
        return "Section{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", siza='" + siza + '\'' +
                ", downlad='" + downlad + '\'' +
                ", duration='" + duration + '\'' +
                ", date=" + date +
                ", album_id='" + album_id + '\'' +
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

    public String getSiza() {
        return siza;
    }

    public void setSiza(String siza) {
        this.siza = siza;
    }

    public String getDownlad() {
        return downlad;
    }

    public void setDownlad(String downlad) {
        this.downlad = downlad;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public Section(String id, String name, String siza, String downlad, String duration, Date date, String album_id) {
        this.id = id;
        this.name = name;
        this.siza = siza;
        this.downlad = downlad;
        this.duration = duration;
        this.date = date;
        this.album_id = album_id;
    }

    public Section() {
    }
}
