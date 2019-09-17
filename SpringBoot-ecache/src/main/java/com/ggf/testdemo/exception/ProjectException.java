package com.ggf.testdemo.exception;

/**
 * @description: 项目异常
 * @author: guoqiangfeng
 * @create: 2019-08-27 16:24
 */
public class ProjectException extends RuntimeException {

  private String code;

  public ProjectException(String code, String message) {
    super(message);
    this.code = code;
  }

  public ProjectException(AbstractProjectCode abstractProjectCode) {
    super(abstractProjectCode.getMessage());
    this.code = abstractProjectCode.getCode();
  }

  public ProjectException(String message) {
    super(message);
  }

  public ProjectException(String message, Throwable cause) {
    super(message, cause);
  }

  public ProjectException(Throwable cause) {
    super(cause);
  }

  protected ProjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
