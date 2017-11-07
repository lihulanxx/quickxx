/*
 * Copyright 2005-2015 shopxx.net. All rights reserved. Support: http://www.shopxx.net License:
 * http://www.shopxx.net/license
 */
package org.quickxx.core.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Exception - 错误验证码
 *
 * @author xiaoshu.lv
 * @since 2017年8月7日16:29:27
 */
public class IncorrectCaptchaException extends AuthenticationException {

  private static final long serialVersionUID = -2452816550297381913L;

  public IncorrectCaptchaException() {}

  public IncorrectCaptchaException(Throwable ex) {
    super(ex);
  }

  public IncorrectCaptchaException(String message) {
    super(message);
  }

  public IncorrectCaptchaException(String message, Throwable ex) {
    super(message, ex);
  }
}
