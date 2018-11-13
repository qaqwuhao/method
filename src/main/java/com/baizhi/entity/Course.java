package com.baizhi.entity;

import java.util.Date;
import java.util.List;

//功课表
public class Course {
    private String id;
//    名称
    private String title;
//    创建时间
    private Date date;
//一个功课有多个计数器
    private List<Counter>counters;

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", counters=" + counters +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }

    public Course(String id, String title, Date date, List<Counter> counters) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.counters = counters;
    }

    public Course() {
    }
}
