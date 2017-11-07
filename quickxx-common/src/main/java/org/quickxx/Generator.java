package org.quickxx;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成.
 * 
 * @author xiaoshu.lv
 */
public class Generator {

  /**
   * 测试 run 执行
   * <p>
   * 配置方法查看 {@link}
   * </p>
   */
  public static void main(String[] args) {

    final String moduleName = "shop";

    //-------------------------------以上为同一项目不同模块需要自定义的配置



    AutoGenerator mpg = new AutoGenerator();
    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    gc.setOutputDir("G://");
    gc.setFileOverride(false);
    gc.setActiveRecord(false);
    gc.setEnableCache(false);// XML 二级缓存
    gc.setBaseResultMap(true);// XML ResultMap
    gc.setBaseColumnList(false);// XML columList
    gc.setAuthor("xiaoshu.lv");
    // 自定义文件命名，注意 %s 会自动填充表实体属性！
    // gc.setMapperName("%sDao");
    // gc.setXmlName("%sDao");
    // gc.setServiceName("MP%sService");
    // gc.setServiceImplName("%sServiceDiy");
    // gc.setControllerName("%sAction");
    mpg.setGlobalConfig(gc);
    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setDbType(DbType.MYSQL);
    dsc.setDriverName("com.mysql.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("zxcvbnm");
    dsc.setUrl("jdbc:mysql://106.14.206.213:3306/quickxxx?characterEncoding=utf8");
    mpg.setDataSource(dsc);
    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    String[] prefix = {moduleName+"_"};
    strategy.setTablePrefix(prefix);// 此处可以修改为您的表前缀
    strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
    //strategy.setInclude(new String[] {"sys_log","sys_admin","sys_admin_role","sys_role"}); // 需要生成的表
    strategy.setInclude(new String[] {"shop_ad"});
    // strategy.setExclude(new String[]{"test"}); // 排除生成的表
    // 字段名生成策略
    //strategy.setFieldNaming(NamingStrategy.underline_to_camel);
    // 自定义实体父类
    strategy.setSuperEntityClass("org.quickxx.core.base.BaseModel");
    // 自定义实体，公共字段
    strategy.setSuperEntityColumns(new String[] {"id", "create_date", "modify_date", "version","update_by","create_by","enable","remark"});
    // 自定义 mapper 父类
    strategy.setSuperMapperClass("org.quickxx.core.base.BaseMapper");
    // 自定义 service 父类
    strategy.setSuperServiceClass("org.quickxx.core.base.BaseService");
    // 自定义 service 实现类父类
    strategy.setSuperServiceImplClass("org.quickxx.core.base.BaseServiceImpl");
    // 自定义 controller 父类
    strategy.setSuperControllerClass("org.quickxx.core.base.BaseController");
    // 【实体】是否生成字段常量（默认 false）
    // public static final String ID = "test_id";
    // strategy.setEntityColumnConstant(true);
    // 【实体】是否为构建者模型（默认 false）
    // public User setName(String name) {this.name = name; return this;}
    // strategy.setEntityBuliderModel(true);
    mpg.setStrategy(strategy);
    // 包配置
    String module = "."+moduleName;
    PackageConfig pc = new PackageConfig();
    pc.setParent("org.quickxx");
    pc.setEntity("model" + module);
    pc.setMapper("dao" + module);
    pc.setXml("dao" + module);
    pc.setService("service" + module);
    pc.setServiceImpl("service" + module + ".impl");
    pc.setController("web" + module);
    mpg.setPackageInfo(pc);
    // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
    // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
    InjectionConfig cfg = new InjectionConfig() {
      public void initMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("moduleName",moduleName);
        this.setMap(map);
      }
    };
    mpg.setCfg(cfg);
    // 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
    TemplateConfig tc = new TemplateConfig();
    tc.setEntity("template/entity.java.vm");
    tc.setMapper("template/mapper.java.vm");
    tc.setXml("template/mapper.xml.vm");
    tc.setServiceImpl("template/serviceImpl.java.vm");
    tc.setController("template/controller.java.vm");
    mpg.setTemplate(tc);
    // 执行生成
    mpg.execute();
  }
}
