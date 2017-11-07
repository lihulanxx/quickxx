package org.quickxx.core.support;

/**
 *
 *
 * @author xiaoshu.lv
 * @since 2017年8月7日15:33:02
 */
public class ResponseJson {
  /**
   * 响应业务状态
   */
  private int status;
  /**
   * 响应消息
   */
  private String msg;
  /**
   * 响应中的数据
   */
  private Object data;

  // 封装AJAX json数据
  public ResponseJson(int status, String msg, Object data) {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }

  public static ResponseJson build(HttpCode httpCode, String msg) {
    return new ResponseJson(httpCode.value(), msg, null);
  }

  public static ResponseJson build(HttpCode httpCode, String msg, Object data) {
    return new ResponseJson(httpCode.value(), msg, data);
  }

  public static ResponseJson ok(Object data) {
    return new ResponseJson(data);
  }

  public static ResponseJson fruitless() {
    return new ResponseJson(null);
  }

  public ResponseJson(Object data) {
    this.status = 200;
    this.msg = "查询成功";
    this.data = data;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
