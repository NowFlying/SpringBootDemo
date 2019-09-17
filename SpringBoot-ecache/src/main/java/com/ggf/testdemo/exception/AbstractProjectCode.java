package com.ggf.testdemo.exception;

/**
 * @description: 项目错误码规范接口
 * @author: guoqiangfeng
 * @create: 2019-08-27 16:22
 */
public interface AbstractProjectCode {

  /**
   * 获取异常的状态码
   */
  String getCode();

  /**
   * 获取异常的提示信息
   */
  String getMessage();

}
