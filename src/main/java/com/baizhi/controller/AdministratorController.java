package com.baizhi.controller;


import com.baizhi.entity.Administrator;
import com.baizhi.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("login")
public class AdministratorController {
    

    @Autowired
    private AdministratorService administratorService;


    @RequestMapping("login")
    public String login(Administrator administrator,HttpSession session,String enCode){
        Administrator login =administratorService.login(administrator);
        Object validationCode = session.getAttribute("validationCode");
        if(enCode.equals(validationCode)) {
            if (login!=null) {
                session.setAttribute("administrator", login);
                return "/back/main/main";
            } else {
                return "/back/login";
            }
        }else{
            return "/back/login";
        }
    }
    //        查一个
    @RequestMapping("findone")
    public @ResponseBody Administrator find(String id) {
        Administrator allone = administratorService.findAllone(id);
        return allone;
    }
//        更改
    @RequestMapping("update")
    public @ResponseBody Map<String,Object>
    date(Administrator administrator,HttpSession session) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            Administrator allone = administratorService.findAllone(administrator.getId());
            if(allone.getPassword()==administrator.getPassword()){
                result.put("success",false);
                result.put("message","不能和旧密码一样");
            }else{
                allone.setPassword(administrator.getPassword());
                administratorService.update(allone);
                result.put("success",true);
                result.put("message","修改成功");

            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("message","修改失败");
        }
        return result;
    }

    @RequestMapping("baibai")
    public String baibai(HttpSession session){
       session.removeAttribute("administrator");
       return "/back/login";
    }
}


