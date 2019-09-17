package com.ggf.springboot.adminclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @description: adminclient配置类
 * @author: guoqiangfeng
 * @create: 2019-09-17 11:29
 */
@Configuration
public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().permitAll()
        .and().csrf().disable();
  }
}
