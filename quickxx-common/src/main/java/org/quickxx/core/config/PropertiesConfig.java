package org.quickxx.core.config;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.quickxx.core.format.StringFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

/**
 * 自定义properties conversionService
 *
 * @author xiaoshu.lv
 * @since 2017-08-02 17:11
 **/
/*@Configuration
public class PropertiesConfig {

  @Resource
  private Formatter stringFormat;

  @Bean(name = "conversionService")
  public FormattingConversionServiceFactoryBean getConversionService() {
    FormattingConversionServiceFactoryBean bean = new FormattingConversionServiceFactoryBean();
    Set<Formatter> formatters = new HashSet<>();
    formatters.add(new StringFormat());
    bean.setFormatters(formatters);
    return bean;
  }
}*/
