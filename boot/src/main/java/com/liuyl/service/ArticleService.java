package com.liuyl.service;

import com.liuyl.pojo.Article;

import java.util.List;

/**
 * Created by liuyl on 2017/8/3.
 */
public interface ArticleService {
    /**
     * 得到文章详细信息
     * @return list
     */
    List<Article> getAriticleDetail();
}
