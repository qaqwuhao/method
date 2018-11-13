package com.baizhi.entity;

import java.util.Date;

//计数器表
public class Counter {
    private String id;
//    计数器名
    private String name;
//    创建时间
    private Date date;
//    数值
    private String count;

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", count='" + count + '\'' +
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Counter(String id, String name, Date date, String count) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.count = count;
    }

    public Counter() {
    }
}
