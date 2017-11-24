package com.liuyl.controller;

import com.alibaba.fastjson.JSONObject;
import com.liuyl.dao.UserDao;
import com.liuyl.pojo.User;
import com.liuyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyl on 2017/9/14.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserDao userMapper;
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/userQuery")
    public Object queryUser(@RequestParam String username,@RequestParam String password,HttpServletRequest request) {
        User user = userMapper.queryUserByName(username);
        boolean result =userService.UserVerify(user,username,password);
        if (result){
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("password",password);
            return user;
        }
        return  null;
    }
}
