package com.ggf.springboot.eventdemo.service;


import com.ggf.springboot.eventdemo.entity.UserBean;
import com.ggf.springboot.eventdemo.event.UserRegisterEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Descripton TODO
 * @Author: gqf
 * @create: 2019-05-28 20:42
 */
@Service
public class UserService {

    @Autowired
    ApplicationContext applicationContext;

    /**
     * 用户注册
     * */
    public  void register(UserBean user){
        applicationContext.publishEvent(new UserRegisterEvent(this,user));
    }
}
