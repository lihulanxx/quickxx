package org.quickxx.core.base;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * 实体基类
 *
 * @author xiaoshu.lv
 * @since 2017年8月2日14:03:26
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseModel implements Serializable {
  private static final long serialVersionUID = -7103197793672462521L;

  /**
   * 主键
   */
  @TableId(type = IdType.ID_WORKER)
  private Long id;

  /**
   * 创建日期
   */
  private Date createDate;
  /**
   * 修改日期
   */
  private Date modifyDate;
  /**
   * 修改人
   */
  private Long updateBy;
  /**
   * 创建人
   */
  private Long createBy;
  /**
   * 删除状态
   */
  private Integer enable;
  /**
   * 备注
   */
  private String remark;
  /**
   * 版本
   */
  @Version
  private Long version;


  /**
   * 判断是否为新建对象
   *
   * @return 是否为新建对象
   */
  public boolean isNew() {
    return getId() == null;
  }
}
