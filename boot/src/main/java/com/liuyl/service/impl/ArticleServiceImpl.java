package com.liuyl.service.impl;

import com.liuyl.pojo.Article;
import com.liuyl.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    private static final String  ARITICLE_SQL= "select * from zblog.article";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Article> getAriticleDetail(){
        List<Article> articleList = jdbcTemplate.query(ARITICLE_SQL,new BeanPropertyRowMapper<>(Article.class));
        return articleList;
    }
}
