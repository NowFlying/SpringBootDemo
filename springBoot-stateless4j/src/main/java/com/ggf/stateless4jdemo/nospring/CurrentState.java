package com.ggf.stateless4jdemo.nospring;

/**
 * @description: 超级玛丽的状态
 * @author: guoqiangfeng
 * @create: 2020-05-14 15:27
 */
public enum CurrentState {

  // 蘑菇小的状态
  SMALL,

  // 吃完蘑菇变大的状态
  BIG,

  // 吃到花朵，可以攻击
  ATTACH,

  // 死亡
  DEAD;

}
