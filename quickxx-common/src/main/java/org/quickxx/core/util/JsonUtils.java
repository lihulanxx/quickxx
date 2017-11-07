package org.quickxx.core.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * json util
 */
public class JsonUtils {
  private static final Logger logger = LogManager.getLogger();
  // 定义jackson对象
  private static final ObjectMapper MAPPER = new ObjectMapper();

  /**
   * 传入配置信息
   *
   */
  static {
    // 解决Jackson转译字符异常(Illegal unquoted character)
    MAPPER.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    // 解决Jackson未知字段异常(not marked as ignorable)，生产环境推荐使用true
    MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    // 解决Jackson空字符串构造器异常(no single-String constructor/factory method)
    MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    //解决Jackson日期格式的问题
    MAPPER.setDateFormat( new SimpleDateFormat("yyyy-MM-dd"));
  }

  /**
   * 将对象转换成json字符串。
   * <p>
   * Title: pojoToJson
   * </p>
   * <p>
   * Description:
   * </p>
   * 
   * @param data
   * @return
   */
  public static String objectToJson(Object data) {
    String result = null;
    try {
      result = MAPPER.writeValueAsString(data);
      return result;
    } catch (JsonProcessingException e) {
      logger.error(e);
      return result;
    }

  }

  /**
   * 将json结果集转化为对象
   * 
   * @param jsonData json数据
   * @param beanType 对象中的object类型
   * @return
   */
  public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
    try {
      T t = MAPPER.readValue(jsonData, beanType);
      return t;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 将json结果集转化为对象
   *
   * @param jsonData json数据
   * @param beanType 对象中的object类型
   * @return
   */
  public static <T> T jsonToPojo(String jsonData, TypeReference beanType) throws IOException {
    T t = MAPPER.readValue(jsonData, beanType);
    return t;
  }

  /**
   * 将json数据转换成pojo对象list
   * <p>
   * Title: jsonToList
   * </p>
   * <p>
   * Description:
   * </p>
   *
   * @param jsonData
   * @param parametrized
   * @param parameterClasses
   * @return
   */
  public static <T> T jsonToPojo(String jsonData,Class<?> parametrized,
                                 Class<?> parameterClasses)
      throws IOException {
    JavaType type = MAPPER.getTypeFactory().constructParametrizedType(parametrized, parametrized,parameterClasses);
    T t = MAPPER.readValue(jsonData, type);
    return t;
  }

  /**
   * 将json数据转换成pojo对象list
   * <p>
   * Title: jsonToList
   * </p>
   * <p>
   * Description:
   * </p>
   * 
   * @param jsonData
   * @param beanType
   * @return
   */
  public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
    JavaType javaType =
        MAPPER.getTypeFactory().constructParametrizedType(ArrayList.class,ArrayList.class, beanType);
    try {
      List<T> list = MAPPER.readValue(jsonData, javaType);
      return list;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
  
  /**
   * 将json数据转换成pojo对象list
   * <p>
   * Title: jsonToList
   * </p>
   * <p>
   * Description:
   * </p>
   * 
   * @param jsonData
   * @param beanType
   * @return
   */
  public static <T> List<T> jsonToListWithPara(String jsonData, TypeReference beanType) throws IOException {
	  List<T> list = MAPPER.readValue(jsonData, beanType);
	return list;
  }
  /**
   * 将json结果集转化为节点树
   * 
   * @param jsonData json数据
   * @return
   */
  public static JsonNode jsonToNodeTree(String jsonData) {
    try {
      JsonNode node = MAPPER.readTree(jsonData);
      return node;
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
