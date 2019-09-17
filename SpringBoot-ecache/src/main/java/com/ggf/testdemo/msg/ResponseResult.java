package com.ggf.testdemo.msg;

import com.ggf.testdemo.enums.SystemCodeEnum;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 响应结果
 * @author: guoqiangfeng
 * @create: 2019-08-27 18:45
 */
public class ResponseResult {

  /**
   *
   * @author guoqiangfeng
   * @Description: 成功设置参数名和参数值
   * @date: 2019/8/27 18:49
   * @param paramName 参数名
   * @return
   */
  public static <T> ObejectResultResponse<Map<String, T>> success(String paramName, T t) {
    ObejectResultResponse<Map<String, T>> ObjectRestResponse = new ObejectResultResponse<>();
    Map<String, T> resultMap = new HashMap<>();
    ObjectRestResponse.setCode(SystemCodeEnum.SUCCESS_0000.getCode());
    resultMap.put(paramName, t);
    ObjectRestResponse.data(resultMap);
    return ObjectRestResponse;
  }


  /**
   *
   * @author guoqiangfeng
   * @Description: 成功有data
   * @date: 2019/8/27 18:48
   * @param
   * @return
   */
  public static <T> ObejectResultResponse<Map<String, T>> success(Map<String, T> paramMap) {
    ObejectResultResponse<Map<String, T>> ObjectRestResponse = new ObejectResultResponse<>();
    ObjectRestResponse.setCode(SystemCodeEnum.SUCCESS_0000.getCode());
    ObjectRestResponse.setData(paramMap);
    return ObjectRestResponse;
  }

  /**
   *
   * @author guoqiangfeng
   * @Description: 成功没有data
   * @date: 2019/8/27 18:47
   * @param
   * @return
   */
  public static <T> ObejectResultResponse<Map<String, T>> success() {
    ObejectResultResponse<Map<String, T>> ObjectRestResponse = new ObejectResultResponse<>();
    ObjectRestResponse.setCode(SystemCodeEnum.SUCCESS_0000.getCode());
    Map<String, T> resultMap = new HashMap<>();
    ObjectRestResponse.setData(resultMap);
    return ObjectRestResponse;
  }


  /**
   * @author guoqiangfeng
   * @Description: 错误
   * @date: 2019/8/27 18:46
   */
  public static <T> ObejectResultResponse<Map<String, T>> error(String code, String message) {
    ObejectResultResponse<Map<String, T>> ObjectRestResponse = new ObejectResultResponse<>();
    ObjectRestResponse.setCode(code);
    Map<String, T> resultMap = new HashMap<>();
    ObjectRestResponse.setData(resultMap);
    ObjectRestResponse.setMsg(message);
    return ObjectRestResponse;
  }
}
