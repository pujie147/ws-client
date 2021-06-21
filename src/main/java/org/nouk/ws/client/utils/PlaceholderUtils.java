package org.nouk.ws.client.utils;

import com.codahale.metrics.Gauge;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * 配置文件或模板中的占位符替换工具类
 * Date: 15-5-8
 * Time: 下午4:12
 */
public class PlaceholderUtils {

    /**
     * Prefix for system property placeholders: "${"
     */
    public static final String PLACEHOLDER_PREFIX = "${";
    /**
     * Suffix for system property placeholders: "}"
     */
    public static final String PLACEHOLDER_SUFFIX = "}";

    public static String resolvePlaceholders(String text, Map<String, Gauge<String>> parameter) {
        if (parameter == null || parameter.isEmpty()) {
            return text;
        }
        StringBuffer buf = new StringBuffer(text);
        int startIndex = buf.indexOf(PLACEHOLDER_PREFIX);
        while (startIndex != -1) {
            int endIndex = buf.indexOf(PLACEHOLDER_SUFFIX, startIndex + PLACEHOLDER_PREFIX.length());
            if (endIndex != -1) {
                String placeholder = buf.substring(startIndex + PLACEHOLDER_PREFIX.length(), endIndex);
                int nextIndex = endIndex + PLACEHOLDER_SUFFIX.length();
                try {
                    Gauge<String> propVal = parameter.get(placeholder);
//                    propVal = parameter.get(placeholder);
                    if (propVal != null) {
                        buf.replace(startIndex, endIndex + PLACEHOLDER_SUFFIX.length(), propVal.getValue());
                        nextIndex = startIndex + propVal.getValue().length();
                    } else {
                        System.out.println("Could not resolve placeholder '" + placeholder + "' in [" + text + "] ");
                    }
                } catch (Exception ex) {
                    System.out.println("Could not resolve placeholder '" + placeholder + "' in [" + text + "]: " + ex);
                }
                startIndex = buf.indexOf(PLACEHOLDER_PREFIX, nextIndex);
            } else {
                startIndex = -1;
            }
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        String aa= "我们都是好孩子,${num}说是嘛？ 我觉得${people}是傻蛋!";
        Map<String, Gauge<String>> map = new HashMap<String, Gauge<String>>();
        map.put("num",()->{return "小米"+ new Random().nextInt(50);});
        map.put("people",()->{return "小明"+ new Random().nextInt(50);});
        System.out.println(PlaceholderUtils.resolvePlaceholders(aa, map));
    }

}