package com.liuyl.service.impl;

import com.liuyl.pojo.User;
import com.liuyl.service.UserService;
import com.liuyl.util.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by liuyl on 2017/10/19.
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public boolean UserVerify(User user, String username, String password) {

        if (!user.getLocked()){
            if (StringUtils.equals(user.getPassword(),Md5Util.pwdDigest(password))){
                return true;
            }
            return false;
        }

        return false;
    }
}
