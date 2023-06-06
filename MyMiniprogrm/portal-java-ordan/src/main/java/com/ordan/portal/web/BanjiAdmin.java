package com.ordan.portal.web;

import com.alibaba.fastjson.JSONObject;
import com.ordan.portal.biz.IBanjiBiz;
import com.ordan.portal.dao.IBanjiDao;
import com.ordan.portal.entity.Banjiinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/banji")
public class BanjiAdmin {

    @Autowired
    private IBanjiBiz banjiBiz;

    @ResponseBody
    @RequestMapping(value = "/sid.mvc",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public JSONObject findBySid(@RequestParam("sid") int sid){

        JSONObject json = new JSONObject();

        List<Banjiinfo> list = banjiBiz.findBySid(sid);

        json.put("list",list);
        System.out.println("班级共=" + list.size() +"条");
        return json;
    }



}
