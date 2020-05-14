package com.ggf.springstatemachine.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

/**
 * @description: 启动之后的操作
 * @author: guoqiangfeng
 * @create: 2020-05-14 13:52
 */
@Component
public class AfterStart implements CommandLineRunner {

  @Autowired
  private StateMachine<States, Events> stateMachine;

  @Override
  public void run(String... args) throws Exception {
    stateMachine.start();
    stateMachine.sendEvent(Events.PAY);
    stateMachine.sendEvent(Events.RECEVICE);
  }
}
