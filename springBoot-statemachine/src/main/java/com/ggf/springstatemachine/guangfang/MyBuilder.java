package com.ggf.springstatemachine.guangfang;

import java.util.EnumSet;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.StateMachineBuilder.Builder;

/**
 * @description: 构建者
 * @author: guoqiangfeng
 * @create: 2020-05-14 11:03
 */
@Configuration
public class MyBuilder {


  public StateMachine<States, Events> buildMachine() throws Exception{
    Builder<States, Events> builder = StateMachineBuilder.builder();

    builder.configureStates()
        .withStates()
          .initial(States.STATE1)
          .states(EnumSet.allOf(States.class));

    builder.configureTransitions()
        .withExternal()
          .source(States.STATE1).target(States.STATE2)
          .event(Events.EVENT1)
          .and()
        .withExternal()
          .source(States.STATE2).target(States.STATE1)
          .event(Events.EVENT2);

    return builder.build();
  }



}
