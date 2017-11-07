/*
 * Copyright 2005-2015 shopxx.net. All rights reserved. Support: http://www.shopxx.net License:
 * http://www.shopxx.net/license
 */
package org.quickxx.core.exception;

import org.quickxx.core.support.HttpCode;

/**
 * Exception - 资源不存在
 *
 * @author xiaoshu.lv
 * @since 2017年8月7日16:29:27
 */
public class ResourceNotFoundException extends BaseException {

  private static final long serialVersionUID = -9208522773597070069L;

  public ResourceNotFoundException() {}

  public ResourceNotFoundException(Throwable ex) {
    super(ex);
  }

  public ResourceNotFoundException(String message) {
    super(message);
  }

  public ResourceNotFoundException(String message, Throwable ex) {
    super(message, ex);
  }

  @Override
  protected HttpCode getHttpCode() {
    return null;
  }
}
