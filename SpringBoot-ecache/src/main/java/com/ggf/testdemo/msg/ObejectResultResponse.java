package com.ggf.testdemo.msg;

/**
 * @description: 返回对象类
 * @author: guoqiangfeng
 * @create: 2019-08-27 10:23
 */
public class ObejectResultResponse<T> extends BaseResponse {

  T datas;

  public ObejectResultResponse data(T datas) {
    this.datas = datas;
    return this;
  }

  public T getData() {
    return datas;
  }

  public void setData(T datas) {
    this.datas = datas;
  }
}
