package com.liuyl.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liuyl on 2017/8/23.
 */
public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private String enabled;
    private String credential;
    private boolean locked;
    private String expired;
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public boolean getLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", enabled='" + enabled + '\'' + ", credential='" + credential + '\'' + ", locked='" + locked + '\'' + ", expired='" + expired + '\'' + ", createTime='" + createTime + '\'' + '}';
    }
}
