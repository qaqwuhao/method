package com.baizhi.controller;

import com.baizhi.entity.Users;
import com.baizhi.service.UsersService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("findAll")
    @ResponseBody
    public Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        List<Users> users = usersService.findByPage(page, rows);
        Long totals = usersService.findTotals();

        results.put("total",totals);
        results.put("rows",users);
        return results;
    }


//    修改
    @RequestMapping("update")
    @ResponseBody
    public Map<String,Object> update(Users users){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            usersService.update(users);
            result.put("success",true);
            result.put("message","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("message","修改失败");
        }
        return result;
    }

//注册
@RequestMapping("add")
@ResponseBody
public Map<String,Object> add(Users users) {
    Map<String, Object> result = new HashMap<String, Object>();
       try {

           String password = users.getPassword();
           String s = DigestUtils.md5Hex(password);
           users.setPassword(s);
           usersService.add(users);
           result.put("success",true);
         result.put("message","注册成功");
      } catch (Exception e) {
         e.printStackTrace();
         result.put("success",false);
          result.put("message","注册失败");
      }
      return result;
    }
//    登陆
    @RequestMapping("login")
    public String login(Users users, String code, HttpSession session){
        String password = users.getPassword();
        String s = DigestUtils.md5Hex(password);
        users.setPassword(s);
        Boolean login = usersService.login(users);
        if(session.getAttribute("validationCode").equals(code)) {
            //验证码正确
            if(login){
                //登陆成功
                return null;
            }else{
                //登陆失败
                return null;
            }
        }else{
            //验证码错误
            return null;
        }
    }
//查询单个
    @RequestMapping("findone")
    @ResponseBody
    public Users findone(String id){
        Users findone = usersService.findone(id);
        return findone;
    }
}
