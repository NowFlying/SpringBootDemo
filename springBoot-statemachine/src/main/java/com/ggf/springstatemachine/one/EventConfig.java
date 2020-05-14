package com.ggf.springstatemachine.one;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @description: 事件配置类
 * @author: guoqiangfeng
 * @create: 2020-05-14 14:58
 */
@WithStateMachine
@Slf4j
public class EventConfig {

  @OnTransition(target = "UNPAID")
  public void create(){
    log.info("创建完订单了");
  }

  @OnTransition(source = "UNPAID", target = "WAIT_FOR_RECEIVE")
  public void pay(){
    log.info("用户已经支付，等待收货");
  }

  @OnTransition(source = "WAIT_FOR_RECEIVE", target = "DONE")
  public void receive(){
    log.info("用户已经收货了，订单完成了");
  }


}
