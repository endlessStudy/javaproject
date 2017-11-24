package com.liuyl.controller;

import com.liuyl.dao.AriticleDao;
import com.liuyl.dao.UserDao;
import com.liuyl.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by liuyl on 2017/11/23.
 */
@Controller
public class test {
    @Autowired
    AriticleDao ariticleMapper;
    @ResponseBody
    @RequestMapping("test")
    public String test(){
        return "13246";
    }
    @ResponseBody
    @RequestMapping("test1")
    public List<Article> test1(HttpServletResponse response){
        return ariticleMapper.queryAriticle();
    }
}
