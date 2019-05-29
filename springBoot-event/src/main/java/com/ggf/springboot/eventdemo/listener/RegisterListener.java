package com.ggf.springboot.eventdemo.listener;


import com.ggf.springboot.eventdemo.entity.UserBean;
import com.ggf.springboot.eventdemo.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Descripton 原始的方式实现
 * @Author: gqf
 * @create: 2019-05-28 21:07
 */
@Component
public class RegisterListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        UserBean user = userRegisterEvent.getUser();
        System.out.println("事件监听，用户名：" + user.getName() + ",密码:" + user.getPassword());
    }
}
