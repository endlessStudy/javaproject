package com.liuyl.controller;

import com.liuyl.pojo.Article;
import com.liuyl.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    ArticleService articleService;
    @RequestMapping(name = "/detail")
    @ResponseBody
    public List<Article> queryArticle(){
        logger.info("--查询文章详情--");
        return articleService.getAriticleDetail();
    }
}
