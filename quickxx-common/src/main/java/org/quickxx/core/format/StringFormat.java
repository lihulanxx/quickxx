package org.quickxx.core.format;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 字符串转换类
 *
 * @author xiaoshu.lv
 * @since 2017-08-02 16:23
 **/
@Component("stringFormat")
public class StringFormat implements Formatter<String> {
  @Override
  public String parse(String text, Locale locale) throws ParseException {
    if (!StringUtils.hasText(text)) {
      return null;
    }
    return text;
  }

  @Override
  public String print(String object, Locale locale) {
    return object;
  }
}
