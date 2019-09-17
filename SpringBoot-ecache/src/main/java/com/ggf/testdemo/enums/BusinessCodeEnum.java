package com.ggf.testdemo.enums;

import com.ggf.testdemo.exception.AbstractProjectCode;

/**
 * @description: 业务异常枚举
 * @author: guoqiangfeng
 * @create: 2019-08-27 16:34
 */
public enum BusinessCodeEnum implements AbstractProjectCode{
  FILE_UPLOAD_FAIL("10000", "文件上传失败"),
  FILE_DOWNLOAD_FAIL("10001", "文件下载失败"),
  FILE_TYPE_FAIL("10002", "文件类型错误"),
  FILE_NOT_FOUND("10003", "文件不存在"),
  ;

  private String code;
  private String message;

  BusinessCodeEnum(String code, String message) {
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
