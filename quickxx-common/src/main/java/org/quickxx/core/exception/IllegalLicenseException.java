/*
 * Copyright 2005-2015 shopxx.net. All rights reserved. Support: http://www.shopxx.net License:
 * http://www.shopxx.net/license
 */
package org.quickxx.core.exception;

import org.quickxx.core.support.HttpCode;

/**
 * Exception - 非法商业许可
 * 
 * @author xiaoshu.lv
 * @since 2017年8月7日16:29:27
 */
public class IllegalLicenseException extends BaseException {

  private static final long serialVersionUID = 8756459486934299648L;

  public IllegalLicenseException() {}

  public IllegalLicenseException(Throwable ex) {
    super(ex);
  }

  public IllegalLicenseException(String message) {
    super(message);
  }

  public IllegalLicenseException(String message, Throwable ex) {
    super(message, ex);
  }

  @Override
  protected HttpCode getHttpCode() {
    return null;
  }
}
