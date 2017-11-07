/*
 * Copyright 2005-2015 shopxx.net. All rights reserved. Support: http://www.shopxx.net License:
 * http://www.shopxx.net/license
 */
package org.quickxx.core.base;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.quickxx.core.exception.IllegalLicenseException;
import org.quickxx.core.exception.ResourceNotFoundException;
import org.quickxx.core.support.HttpCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.method.HandlerMethod;

/**
 * Controller - 基类
 * 
 * @author xiaoshu.lv
 * @since 2017年8月2日14:00:24
 */
public class BaseController {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  /** 验证结果 */
  private static final String CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME = "constraintViolations";

  @Resource(name = "validator")
  private Validator validator;

  @Resource
  private MessageSource messageSource;

  /**
   * 数据绑定(旧版spring的解决方案)
   *
   * @param binder WebDataBinder
   */
  /*
   * @InitBinder protected void initBinder(WebDataBinder binder) { // 空字符串转null
   * binder.registerCustomEditor(String.class, new StringTrimmerEditor(true)); //日期转换
   * binder.registerCustomEditor(Date.class, new DateEditor(true)); //密码允许空格
   * binder.registerCustomEditor(String.class, "password", new StringEditor(true)); }
   */

  /**
   * 异常处理
   * 
   * @param exception 异常
   * @param response HttpServletResponse
   * @return ResponseEntity
   */
  @ExceptionHandler
  @ResponseBody
  public ResponseEntity exceptionHandler(Exception exception, HttpServletRequest request,
      HttpServletResponse response, Object handler) {
    Integer status = null;
    if (exception instanceof ResourceNotFoundException) {
      status = HttpCode.NOT_FOUND.value();
    } else if (exception instanceof IllegalLicenseException) {
      status = HttpCode.FORBIDDEN.value();
    } else {
      String message;
      if (handler instanceof HandlerMethod) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s", request.getRequestURI(),
            handlerMethod.getBean().getClass().getName(), handlerMethod.getMethod().getName(),
            exception.getMessage());
      } else {
        message = exception.getMessage();
      }
      logger.error(message, exception);
      status = HttpCode.INTERNAL_SERVER_ERROR.value();
    }
    return ResponseEntity.status(status).body(message(status.toString()));
  }

  /**
   * 数据验证
   * 
   * @param target 验证对象
   * @param groups 验证组
   * @return 验证结果
   */
  protected boolean isValid(Object target, Class<?>... groups) {
    Assert.notNull(target);

    Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target, groups);
    if (constraintViolations.isEmpty()) {
      return true;
    }
    RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
    requestAttributes.setAttribute(CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME, constraintViolations,
        RequestAttributes.SCOPE_REQUEST);
    return false;
  }

  /**
   * 数据验证
   * 
   * @param targets 验证对象
   * @param groups 验证组
   * @return 验证结果
   */
  protected boolean isValid(Collection<Object> targets, Class<?>... groups) {
    Assert.notEmpty(targets);

    for (Object target : targets) {
      if (!isValid(target, groups)) {
        return false;
      }
    }
    return true;
  }

  /**
   * 数据验证
   * 
   * @param type 类型
   * @param property 属性
   * @param value 值
   * @param groups 验证组
   * @return 验证结果
   */
  protected boolean isValid(Class<?> type, String property, Object value, Class<?>... groups) {
    Assert.notNull(type);
    Assert.hasText(property);

    Set<?> constraintViolations = validator.validateValue(type, property, value, groups);
    if (constraintViolations.isEmpty()) {
      return true;
    }
    RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
    requestAttributes.setAttribute(CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME, constraintViolations,
        RequestAttributes.SCOPE_REQUEST);
    return false;
  }

  /**
   * 数据验证
   * 
   * @param type 类型
   * @param properties 属性
   * @param groups 验证组
   * @return 验证结果
   */
  protected boolean isValid(Class<?> type, Map<String, Object> properties, Class<?>... groups) {
    Assert.notNull(type);
    Assert.notEmpty(properties);

    for (Map.Entry<String, Object> entry : properties.entrySet()) {
      if (!isValid(type, entry.getKey(), entry.getValue(), groups)) {
        return false;
      }
    }
    return true;
  }


  /**
   * 获取国际化消息
   * 
   * @param code 代码
   * @return 国际化消息
   */
  protected String message(String code) {
    Locale locale = LocaleContextHolder.getLocale();
    return messageSource.getMessage(code, null, locale);
  }
}
