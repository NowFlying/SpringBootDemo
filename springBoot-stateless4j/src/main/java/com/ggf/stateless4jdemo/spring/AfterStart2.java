package com.ggf.stateless4jdemo.spring;

import com.ggf.stateless4jdemo.nospring.CurrentState;
import com.ggf.stateless4jdemo.nospring.Trigger;
import com.github.oxo42.stateless4j.StateMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: guoqiangfeng
 * @create: 2020-05-14 16:38
 */
@Component
public class AfterStart2 implements CommandLineRunner {

  @Autowired
  private StateMachine<CurrentState, Trigger> stateMachine;

  @Override
  public void run(String... args) throws Exception {
    stateMachine.fire(Trigger.FLOWER);
    System.out.println(stateMachine.getState());

  }
}
