package com.ggf.springboot.eventdemo.listener;


import com.ggf.springboot.eventdemo.entity.UserBean;
import com.ggf.springboot.eventdemo.event.UserRegisterEvent;
import com.ggf.springboot.eventdemo.service.UserService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Descripton TODO
 * @Author: gqf
 * @create: 2019-05-28 21:22
 */
@Component
public class UserRegisterSendMailListener  implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass ==  UserRegisterEvent.class;
    }

    @Override
    public boolean supportsSourceType(@Nullable Class<?> aClass) {
        return aClass == UserService.class;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    @Async
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        try {
            //睡眠3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //转换事件类型
        UserRegisterEvent userRegisterEvent = (UserRegisterEvent) applicationEvent;
        //获取注册用户对象信息
        UserBean user = userRegisterEvent.getUser();
        System.out.println("用户："+user.getName()+"，注册成功，发送邮件通知。");
    }
}
