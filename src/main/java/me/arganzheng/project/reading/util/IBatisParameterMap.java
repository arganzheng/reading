package me.arganzheng.project.reading.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;

/**
 * 方便构造iBatis的查询对象Map。
 * 
 * @author arganzheng
 * @date 2013-12-7
 */
public class IBatisParameterMap extends HashMap<String, Object> {

    private static final long serialVersionUID = -8518020750436663164L;

    @SuppressWarnings("unchecked")
    public IBatisParameterMap addObjectProperties(Object obj) {
        if (obj != null) {
            Map<String, Object> props = new BeanMap(obj);
            for (Map.Entry<String, Object> prop : props.entrySet()) {
                if (!"class".equals(prop.getKey())) {
                    super.put(prop.getKey(), prop.getValue());
                }
            }
        }

        return this;
    }

    public IBatisParameterMap addParameter(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
