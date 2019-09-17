package com.ggf.testdemo.exception;

/**
 * @description: 系统异常
 * @author: guoqiangfeng
 * @create: 2019-08-27 16:23
 */
public class SystemException extends ProjectException {

  public SystemException(String code, String message) {
    super(code, message);
  }

  public SystemException(AbstractProjectCode abstractProjectCode) {
    super(abstractProjectCode);
  }

  public SystemException(String message) {
    super(message);
  }

  public SystemException(String message, Throwable cause) {
    super(message, cause);
  }

  public SystemException(Throwable cause) {
    super(cause);
  }

  protected SystemException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
