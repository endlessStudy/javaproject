package com.liuyl.pojo;

import javax.swing.text.AbstractDocument;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by liuyl on 2017/8/24.
 */
/*@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)*/
public class Article implements Serializable {
    private long id;
    private long categoryId;
    private String title;
    private String content;
    private String description;
    private int status;
    private String  author;
    private Date createTime;
    private Date updateTime;
    private int showCount;

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", categoryId=" + categoryId + ", title='" + title + '\'' + ", content='" + content + '\'' + ", description='" + description + '\'' + ", status=" + status + ", author='" + author + '\'' + ", createTime=" + createTime + ", updateTime=" + updateTime + ", showCount=" + showCount + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
