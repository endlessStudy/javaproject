package com.liuyl.controller;

import com.liuyl.dao.UserDao;
import com.liuyl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyl on 2017/8/24.
 */
@Controller
@RequestMapping("/html")
public class AriticleControl {
    @Autowired
    private UserDao userMapper;

    @RequestMapping("/homePage")
    //@ResponseBody
    public Map queryUser() {
        Map<String,List<User>> map = new HashMap <>();
        map.put("user",userMapper.queryUser());
        return map;
    }
    @RequestMapping("/homePage")
    //@ResponseBody
    public Map queryAriticle() {
        Map<String,List<User>> map = new HashMap <>();
        map.put("user",userMapper.queryUser());
        return map;
    }
}
