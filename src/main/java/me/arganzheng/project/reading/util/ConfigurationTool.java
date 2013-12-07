package me.arganzheng.project.reading.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 启动的时候加载配置文件，用于在不能使用Spring的@Value注入配置项的时候使用。也可以作为Velocity的一个Tool使用。
 * 
 * @author arganzheng
 * @date 2013-12-07
 */
public class ConfigurationTool {

    private static final Logger        logger        = Logger.getLogger(ConfigurationTool.class);

    private static final String        CONFIG_ENV    = "env";

    private static Map<String, String> propertiesMap = new HashMap<String, String>();

    static {
        String configEnv = System.getenv(CONFIG_ENV);
        if (StringUtils.isBlank(configEnv)) {
            configEnv = System.getProperty(CONFIG_ENV, "idc");
        }
        propertiesMap.put("env", configEnv);
        String resourceName = "reading_" + configEnv + ".properties";
        Properties props = null;
        try {
            props = PropertiesLoaderUtils.loadAllProperties(resourceName);
        } catch (IOException e) {
            logger.error("loadProperties for " + resourceName + " failed!");
        }
        logger.info("loadProperties for " + resourceName + " success!");
        if (props != null) {
            for (Object key : props.keySet()) {
                String keyStr = key.toString();
                String valueStr = props.getProperty(keyStr);
                propertiesMap.put(keyStr, valueStr);
                logger.info("propertiesMap << [" + keyStr + "==>" + valueStr + "]");
            }
        }
    }

    public static String getProperty(String name) {
        return propertiesMap.get(name);
    }

}
