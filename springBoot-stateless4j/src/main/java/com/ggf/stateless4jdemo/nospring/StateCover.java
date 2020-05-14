package com.ggf.stateless4jdemo.nospring;

import com.github.oxo42.stateless4j.StateMachineConfig;

/**
 * @description: 状态转换
 * @author: guoqiangfeng
 * @create: 2020-05-14 15:36
 */

public class StateCover {


  public static StateMachineConfig<CurrentState, Trigger> config = new StateMachineConfig<>();

  static {
    // 开始时小蘑菇
    config.configure(CurrentState.SMALL)
        // 遇到蘑菇变大
        .permit(Trigger.MUSHROOM, CurrentState.BIG)
        // 吃了花就可以变成攻击状态
        .permit(Trigger.FLOWER, CurrentState.ATTACH)
        // 妖怪触发，直接死亡
        .permit(Trigger.MONSTER, CurrentState.DEAD);

    // 开始就是变大的状态
    config.configure(CurrentState.BIG)
        // 忽略吃完蘑菇变大的状态
        .ignore(Trigger.MUSHROOM)
        // 吃了花就可以变成攻击状态
        .permit(Trigger.FLOWER, CurrentState.ATTACH)
        // 妖怪触发，直接死亡
        .permit(Trigger.MONSTER, CurrentState.DEAD);

    // 开始就是攻击
    config.configure(CurrentState.ATTACH)
        // 忽略吃完蘑菇变大的状态
        .ignore(Trigger.MUSHROOM)
        // 忽略吃了花就可以变成攻击状态
        .ignore(Trigger.FLOWER)
        // 妖怪触发，直接死亡
        .permit(Trigger.MONSTER, CurrentState.DEAD);

    // 开始就是死亡
    config.configure(CurrentState.ATTACH)
        // 忽略吃完蘑菇变大的状态
        .ignore(Trigger.MUSHROOM)
        // 忽略吃了花就可以变成攻击状态
        .ignore(Trigger.FLOWER)
        // 妖怪触发，直接死亡
        .ignore(Trigger.MONSTER);

  }



}
