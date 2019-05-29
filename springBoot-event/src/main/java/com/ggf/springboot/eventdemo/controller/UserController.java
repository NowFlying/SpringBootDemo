package com.ggf.springboot.eventdemo.controller;


import com.ggf.springboot.eventdemo.entity.UserBean;
import com.ggf.springboot.eventdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Descripton TODO
 * @Author: gqf
 * @create: 2019-05-28 20:46
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "register")
    public String register(@RequestBody UserBean user){
        userService.register(user);
        return "注册成功！！！";
    }
}
