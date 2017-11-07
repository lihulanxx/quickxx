/**
 * 
 */
package org.quickxx.core.exception;

import org.quickxx.core.support.HttpCode;

/**
 * 
 * @author xiaoshu.lv
 * @since 2017年8月7日16:38:28
 */
public abstract class BaseException extends RuntimeException {
  private static final long serialVersionUID = -3064763773926413390L;

  public BaseException() {}

  public BaseException(Throwable ex) {
    super(ex);
  }

  public BaseException(String message) {
    super(message);
  }

  public BaseException(String message, Throwable ex) {
    super(message, ex);
  }

  protected abstract HttpCode getHttpCode();
}
