package xyz.vopen.framework.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.util.ObjectUtils;

/**
 * Json Util
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 *     <p>
 */
public class JsonUtil {
  /**
   * beautify object to json
   *
   * @param object object
   * @return object json string
   */
  public static String beautifyJson(Object object) {
    if (ObjectUtils.isEmpty(object)) {
      return null;
    }
    return JSON.toJSONString(
        object,
        SerializerFeature.PrettyFormat,
        SerializerFeature.SortField,
        SerializerFeature.MapSortField);
  }

  /**
   * beautify string to json
   *
   * @param json json string
   * @return after beautify json
   */
  public static String beautifyJson(String json) {
    if (ObjectUtils.isEmpty(json)) {
      return json;
    }
    return JSON.toJSONString(JSONObject.parse(json), SerializerFeature.PrettyFormat);
  }
}
