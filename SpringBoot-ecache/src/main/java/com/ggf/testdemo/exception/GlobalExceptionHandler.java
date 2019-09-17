package com.ggf.testdemo.exception;

import com.ggf.testdemo.enums.SystemCodeEnum;
import com.ggf.testdemo.msg.ObejectResultResponse;
import com.ggf.testdemo.msg.ResponseResult;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 全局异常拦截器
 * @author: guoqiangfeng
 * @create: 2019-08-27 18:39
 */
@Slf4j
@ControllerAdvice
@Order(600)
public class GlobalExceptionHandler {

  /**
   *
   * @author guoqiangfeng
   * @Description: Exception异常拦截
   * @date: 2019/8/27 19:25
   * @param
   * @return
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ObejectResultResponse<Map<String, Object>> defaultErrorHandler(HttpServletRequest req, Exception e) {
    log.info("################# 异常开始 #####################");
    log.info("访问URL ：{}", req.getRequestURI());
    log.error("错误信息：{}", e.getCause(), e);

    log.info("################# 异常结束 #####################");
    if (e instanceof BindingResult) {
      BindingResult result = ((BindingResult) e);
      return ResponseResult.error(SystemCodeEnum.ERROR_SE1001.getCode(),
          result.getFieldError().getField() + " : " + result.getFieldError().getDefaultMessage());
    } else if (e instanceof MethodArgumentNotValidException) {
      BindingResult result = ((MethodArgumentNotValidException) e).getBindingResult();
      return ResponseResult.error(SystemCodeEnum.ERROR_SE1001.getCode(),
          result.getFieldError().getField() + " : " + result.getFieldError().getDefaultMessage());
    } else if (e instanceof ProjectException) {
      ProjectException resultF = (ProjectException) e;
      return ResponseResult.error(resultF.getCode(), resultF.getMessage());
    } else {
      return ResponseResult.error(SystemCodeEnum.ERROR_SE9999.getCode(), e.getMessage());
    }
  }

  /**
   *
   * @author guoqiangfeng
   * @Description: Throwable 拦截
   * @date: 2019/8/27 19:26
   * @param
   * @return
   */
  @ExceptionHandler(value = Throwable.class)
  @ResponseBody
  public ObejectResultResponse<Map<String, Object>> unkonwErrorHandler(HttpServletRequest req, Throwable e) {
    log.info("################# 异常开始 #####################");
    log.info("访问URL ：{}", req.getRequestURI());
    log.error(e.getMessage());
    log.info("################# 异常结束 #####################");
    return ResponseResult.error(SystemCodeEnum.ERROR_SE1000.getCode(), e.getMessage());
  }
}
