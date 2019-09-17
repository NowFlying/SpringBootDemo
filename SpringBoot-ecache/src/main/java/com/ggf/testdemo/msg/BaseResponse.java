package com.ggf.testdemo.msg;

import com.ggf.testdemo.enums.SystemCodeEnum;

/**
 * @description: 基础返回信息类
 * @author: guoqiangfeng
 * @create: 2019-08-27 10:13
 */
public class BaseResponse {

  private String code = SystemCodeEnum.SUCCESS_0000.getCode();

  private String msg = SystemCodeEnum.SUCCESS_0000.getMessage();

  public BaseResponse(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public BaseResponse() {
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
