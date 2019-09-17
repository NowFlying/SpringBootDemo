package com.ggf.testdemo.exception;

import java.text.MessageFormat;

/**
 * @description: 自定义业务异常
 * @author: guoqiangfeng
 * @create: 2019-08-27 16:28
 */
public class BusinessException extends ProjectException {

  public BusinessException(String code, String message) {
    super(code, message);
  }

  public BusinessException(AbstractProjectCode abstractProjectCode) {
    super(abstractProjectCode);
  }

  public BusinessException(AbstractProjectCode abstractProjectCode, Object ... objects) {
    super(abstractProjectCode.getCode(), MessageFormat
        .format(abstractProjectCode.getMessage(), objects));
  }

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
  }

  public BusinessException(Throwable cause) {
    super(cause);
  }

  protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
