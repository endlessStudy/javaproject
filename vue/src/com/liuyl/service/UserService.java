package com.liuyl.service;

import com.liuyl.pojo.User;

/**
 * Created by liuyl on 2017/10/19.
 */
public interface UserService {
    boolean UserVerify(User user,String username,String password);
}
