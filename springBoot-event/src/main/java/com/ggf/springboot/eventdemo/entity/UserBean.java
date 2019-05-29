package com.ggf.springboot.eventdemo.entity;


import lombok.Data;

/**
 * @Descripton TODO
 * @Author: gqf
 * @create: 2019-05-28 20:40
 */
@Data
public class UserBean {

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;
}
