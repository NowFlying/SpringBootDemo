package com.ggf.springboot.eventdemo.listener;


import com.ggf.springboot.eventdemo.entity.UserBean;
import com.ggf.springboot.eventdemo.event.UserRegisterEvent;
import com.ggf.springboot.eventdemo.service.UserService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @Descripton 事件有序触发
 * @Author: gqf
 * @create: 2019-05-28 21:16
 */
@Component
public class UserRegisterListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == UserRegisterEvent.class;
    }

    @Override
    public boolean supportsSourceType(@Nullable Class<?> aClass) {
        return aClass == UserService.class;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //转换事件类型
        UserRegisterEvent userRegisterEvent = (UserRegisterEvent) applicationEvent;
        //获取注册用户对象信息
        UserBean user = userRegisterEvent.getUser();
        //.../完成注册业务逻辑
        System.out.println("注册信息，用户名："+user.getName()+"，密码："+user.getPassword());
    }
}
