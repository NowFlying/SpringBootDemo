package com.ggf.testdemo.enums;

/**
 * @description: 开票状态的枚举
 * @author: guoqiangfeng
 * @create: 2019-08-29 17:04
 */
public enum ApplyStatuEnum {

  WAIT("1", "待开票"), FAIL("0", "失败"), INVOICEING("2", "开票中"),SUCCESS("4","开票成功");

  private String code;
  private String message;

  ApplyStatuEnum(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
