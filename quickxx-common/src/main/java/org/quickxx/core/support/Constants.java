/*
 * Copyright 2005-2015 shopxx.net. All rights reserved. Support: http://www.shopxx.net License:
 * http://www.shopxx.net/license
 */
package org.quickxx.core.support;

/**
 * 公共参数
 * 
 * @author xiaoshu.lv
 * @since 2017年8月7日15:33:39
 */
public final class Constants {

  private Constants() {
    throw new IllegalAccessError("Can not instantiate");
  }

  /** 日期格式配比 */
  public static final String[] DATE_PATTERNS =
      new String[] {"yyyy", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd",
          "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss"};

}
