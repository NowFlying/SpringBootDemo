package com.ggf.springboot.eventdemo.listener;


import com.ggf.springboot.eventdemo.entity.UserBean;
import com.ggf.springboot.eventdemo.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Descripton TODO
 * @Author: gqf
 * @create: 2019-05-28 20:52
 */
@Component
public class AnnotationRegisterListener {

    @EventListener
    public void register(UserRegisterEvent userRegisterEvent){
        UserBean user = userRegisterEvent.getUser();
        System.out.println("事件监听，用户名：" + user.getName() + ",密码:" + user.getPassword());
    }

}
