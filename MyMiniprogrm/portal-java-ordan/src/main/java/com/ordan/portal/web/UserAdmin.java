package com.ordan.portal.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

@Controller
@RequestMapping("/user")
public class UserAdmin {
//    ?realName=&Mobile=&sex=&Yzm=&school=&classList=&course=
    @ResponseBody //声明向客户端返回结果为JSON格式
    @RequestMapping(value = "/add.mvc",produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public JSONObject register(
            @RequestParam("realName")   String name,
            @RequestParam("Mobile")     String mobile,
            @RequestParam("sex")        String sex,
            @RequestParam("Yzm")        String yzm,
            @RequestParam("school")     String school,
            @RequestParam("classList")  String classlist,
            @RequestParam("course")     String course
    ){
        JSONObject json = new JSONObject();

        System.out.println("realname=" + name);
        System.out.println("mobile=" + mobile);
        System.out.println("sex=" + sex);
        System.out.println("yzf=" + yzm);
        System.out.println("school=" + school);
        System.out.println("banji=" + classlist);
        System.out.println("course=" + course);

        json.put("code",0); //业务状态码
        json.put("msg","抓到你啦！小黑子");



        return json;
    }

}









