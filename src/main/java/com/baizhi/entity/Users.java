package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

//用户表
public class Users {
    private String id;
//      昵称
    private String name;
//    密码
    private String password;
//    手机号
    private String phone;
//    地址
    private String address;
//    法名
    private String rename;
//    性别
    private String sex;
//    注册时间
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @JsonFormat(pattern ="yyyy-mm-dd")
    private Date date;
//    签名
    private String signaure;
//    头像
    private String head;
//    状态
    private String staus;
    //一个用户有多个功课
    private List<Course>courses;

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", rename='" + rename + '\'' +
                ", sex='" + sex + '\'' +
                ", date=" + date +
                ", signaure='" + signaure + '\'' +
                ", head='" + head + '\'' +
                ", staus='" + staus + '\'' +
                ", courses=" + courses +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSignaure() {
        return signaure;
    }

    public void setSignaure(String signaure) {
        this.signaure = signaure;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Users(String id, String name, String password, String phone, String address, String rename, String sex, Date date, String signaure, String head, String staus, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.rename = rename;
        this.sex = sex;
        this.date = date;
        this.signaure = signaure;
        this.head = head;
        this.staus = staus;
        this.courses = courses;
    }

    public Users() {
    }
}
