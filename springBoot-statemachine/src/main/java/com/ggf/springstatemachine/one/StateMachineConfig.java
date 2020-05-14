package com.ggf.springstatemachine.one;

import java.util.EnumSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

/**
 * @description: 状态机的配置
 * @author: guoqiangfeng
 * @create: 2020-05-14 11:30
 */
@Configuration
@EnableStateMachine
@Slf4j
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {


  // 重新配置状态机的状态，并设置其初始化的状态
  @Override
  public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
    states.withStates()
        .initial(States.UNPAID)
        .states(EnumSet.allOf(States.class));

  }

  // source表示原来的状态，target表示目标的状态
  // event是表示触发的事件
  @Override
  public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
      throws Exception {
    transitions.withExternal()
        .source(States.UNPAID).target(States.WAIT_FOR_RECEIVE)
        .event(Events.PAY)
        .and()
        .withExternal()
        .source(States.WAIT_FOR_RECEIVE).target(States.DONE)
        .event(Events.RECEVICE);
  }

//  // 方法1， 需要进行判断
//  @Override
//  public void configure(StateMachineConfigurationConfigurer<States, Events> config)
//      throws Exception {
//    config.withConfiguration()
//          .listener(listener());
//  }
//
//  @Bean
//  public StateMachineListener<States, Events> listener(){
//    return new StateMachineListenerAdapter<States, Events>(){
//      @Override
//      public void transition(Transition<States, Events> transition) {
//        if(transition.getTarget().getId().equals(States.UNPAID)){
//          log.info("订单创建，待支付");
//          return;
//        }
//
//        if(transition.getTarget().getId().equals(States.WAIT_FOR_RECEIVE)){
//          log.info("用户已支付，待收货");
//          return;
//        }
//
//        if(transition.getTarget().getId().equals(States.DONE)){
//          log.info("用户已收货，订单完成");
//          return;
//        }
//
//      }
//    };
//


//  }






}
