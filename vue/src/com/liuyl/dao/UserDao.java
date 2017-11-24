package com.liuyl.dao;

import com.liuyl.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by liuyl on 2017/8/23.
 */
public interface UserDao {
    /*
     * 查询用户信息
     */
   /* @Select("SELECT id, username, password, enabled, credential, locked, expired, createTime FROM zblog.user")*/
    List<User> queryUser();
    User queryUserByName(@Param("username")String username);
}
