/*
 * Copyright 2005-2015 shopxx.net. All rights reserved. Support: http://www.shopxx.net License:
 * http://www.shopxx.net/license
 */
package org.quickxx.core.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Exception - 错误商业许可
 *
 * @author xiaoshu.lv
 * @since 2017年8月7日16:29:27
 */
public class IncorrectLicenseException extends AuthenticationException {

  private static final long serialVersionUID = 7892631925373485139L;

  public IncorrectLicenseException() {}

  public IncorrectLicenseException(Throwable ex) {
    super(ex);
  }

  public IncorrectLicenseException(String message) {
    super(message);
  }

  public IncorrectLicenseException(String message, Throwable ex) {
    super(message, ex);
  }
}
