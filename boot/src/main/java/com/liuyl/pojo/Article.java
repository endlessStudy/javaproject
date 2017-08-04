package com.liuyl.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liuyl on 2017/8/3.
 */
public class Article implements Serializable{
    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", categroyId=" + categroyId + ", title='" + title + '\'' + ", content='" + content + '\'' + ", description='" + description + '\'' + ", status='" + status + '\'' + ", author='" + author + '\'' + ", createTime=" + createTime + ", updateTime=" + updateTime + ", showCount=" + showCount + '}';
    }

    /**
     * 文章ID
     */
    private long id;
    /**
     * 文章分类
     */
    private long categroyId;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容出处
     */
    private String content;
    /**
     * 文章描述
     */
    private String description;
    /**
     * 文章完结状态
     */
    private String status;
    /**
     * 文章作者
     */
    private String author;
    /**
     * 开始编写时间
     */
    private Date createTime;
    /**
     * 最近更新时间
     */
    private Date updateTime;
    /**
     * 卖出数量
     */
    private int showCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategroyId() {
        return categroyId;
    }

    public void setCategroyId(long categroyId) {
        this.categroyId = categroyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getShowCount() {
        return showCount;
    }

    public void setShowCount(int showCount) {
        this.showCount = showCount;
    }
}
