package com.ggf.stateless4jdemo.spring;

import com.ggf.stateless4jdemo.nospring.CurrentState;
import com.ggf.stateless4jdemo.nospring.StateCover;
import com.ggf.stateless4jdemo.nospring.Trigger;
import com.github.oxo42.stateless4j.StateMachine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 配置类
 * @author: guoqiangfeng
 * @create: 2020-05-14 16:33
 */
@Configuration
public class Config {


  @Bean
  public StateMachine<CurrentState, Trigger> init(){
    return new StateMachine<CurrentState, Trigger>(
        CurrentState.SMALL, StateCover.config);
  }


}
