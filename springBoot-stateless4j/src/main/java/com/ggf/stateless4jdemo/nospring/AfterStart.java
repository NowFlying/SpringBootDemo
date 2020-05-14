package com.ggf.stateless4jdemo.nospring;

import com.github.oxo42.stateless4j.StateMachine;

/**
 * @description: 启动之后
 * @author: guoqiangfeng
 * @create: 2020-05-14 15:53
 */

public class AfterStart {

  public static void main(String[] args) {
    StateMachine<CurrentState, Trigger> stateMachine = new StateMachine<CurrentState, Trigger>(
        CurrentState.SMALL, StateCover.config);

    stateMachine.fire(Trigger.FLOWER);
    System.out.println(stateMachine.getState());

  }
}
