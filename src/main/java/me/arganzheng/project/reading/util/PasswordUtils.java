package me.arganzheng.project.reading.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

/**
 * TODO 类实现描述
 * 
 * @author arganzheng
 * @date 2014-1-20
 */
public class PasswordUtils {

    public static String generatePasswordHash(String password) {
        if (StringUtils.isBlank(password)) {
            return null;
        }
        return DigestUtils.md5Hex(password);
    }

    public static boolean checkPasswordHash(String password, String passwordHash) {
        return StringUtils.equals(passwordHash, generatePasswordHash(password));
    }

}
