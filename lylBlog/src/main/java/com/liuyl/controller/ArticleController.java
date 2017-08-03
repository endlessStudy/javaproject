package com.liuyl.controller;

import com.liuyl.pojo.Article;
import com.liuyl.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liuyl on 2017/8/3.
 */
@Controller
//@RequestMapping(name = "/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @RequestMapping(name = "/detail")
    @ResponseBody
    public List<Article> queryArticle(){
        return articleService.getAriticleDetail();
    }
}
