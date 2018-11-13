package com.baizhi.entity;

import java.util.List;

public class Guru {
    private String id;
//    上师名
    private String name;
//    状态
    private String status;
//    图片
    private String head;
//    一个上师有多篇文章
    private List<Artcle> artcles;

    public Guru() {
    }

    public Guru(String id, String name, String status, String head, List<Artcle> artcles) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.head = head;
        this.artcles = artcles;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public List<Artcle> getArtcles() {
        return artcles;
    }

    public void setArtcles(List<Artcle> artcles) {
        this.artcles = artcles;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", head='" + head + '\'' +
                ", artcles=" + artcles +
                '}';
    }
}
