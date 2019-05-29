package com.ggf.springboot.eventdemo.listener;


import com.ggf.springboot.eventdemo.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Descripton 注册成功以后发送邮件
 * @Author: gqf
 * @create: 2019-05-28 21:09
 */
@Component
public class RegisterUserEmailListener  {

    @EventListener
    public void sendMail(UserRegisterEvent userRegisterEvent){
        System.out.println("用户注册成功发送邮件");
    }
}
