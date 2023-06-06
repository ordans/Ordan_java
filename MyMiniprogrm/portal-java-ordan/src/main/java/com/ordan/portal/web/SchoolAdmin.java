package com.ordan.portal.web;

import com.alibaba.fastjson.JSONObject;
import com.ordan.portal.biz.ISchoolBiz;
import com.ordan.portal.entity.Schoolinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/school")
public class SchoolAdmin {

    @Autowired
    private ISchoolBiz schoolBiz;

    @ResponseBody
    @RequestMapping(value = "/all.mvc",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public JSONObject findAll(){
        JSONObject json = new JSONObject();
        List<Schoolinfo> list = schoolBiz.finfAll();
        System.out.println("size=" + list.size());
        json.put("list",list);
        return json;
    }


}
