package com.ggf.springboot.eventdemo.event;


import com.ggf.springboot.eventdemo.entity.UserBean;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Descripton TODO
 * @Author: gqf
 * @create: 2019-05-28 20:38
 */
@Getter
public class UserRegisterEvent  extends ApplicationEvent {

    private UserBean user;

    /**
     *
     * @param  source 发生事件的对象
     * @param  user 注册用户对象
     * @return
     **/
    public UserRegisterEvent(Object source, UserBean user) {
        super(source);
        this.user = user;
    }
}
