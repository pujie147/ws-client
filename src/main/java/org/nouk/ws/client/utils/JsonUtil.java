package org.nouk.ws.client.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {
    private static boolean isJSON(String str) {
        boolean result = false;
        try {
            JsonObject obj = new JsonParser().parse(str).getAsJsonObject();
            result = true;
        } catch (Exception e) {
            result=false;
        }
        return result;
    }

    /**
     * 格式化输出JSON字符串
     * @return 格式化后的JSON字符串
     */
    public static String toPrettyFormat(String json) {
        if(isJSON(json)) {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(jsonObject);
        }
        return json;
    }
}
