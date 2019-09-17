package com.ggf.testdemo.enums;

import com.ggf.testdemo.exception.AbstractProjectCode;

/**
 * @description: 系统错误异常
 * @author: guoqiangfeng
 * @create: 2019-08-27 16:39
 */
public enum SystemCodeEnum implements AbstractProjectCode {
  /* 成功信息 */
  SUCCESS_0000("0000", "成功"),
  /* 错误信息 */
  ERROR_SE1000("1000","未知异常"),
  ERROR_SE1001("1001","非法参数请求错误"),
  ERROR_SE1002("1002","数据不存在"),
  ERROR_SE1003("1003","签名验签失败"),
  ERROR_SE1004("1004","token已过期"),
  ERROR_SE1005("1005","更新操作异常"),
  ERROR_SE9999("9999","未知错误"),
  ;

  private String code;
  private String message;

  SystemCodeEnum(String code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
