package org.nouk.ws.client.data;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AutoIntervalListModel extends DataPersistence {
    private Map<String,String> datas = new LinkedHashMap();

    public void addData(String key,String data){
        datas.put(key,data);
    }

    public String getData(String key){
        return datas.get(key);
    }

    public void removeData(String key){
        datas.remove(key);
    }

    @PostConstruct
    private void init() throws IOException {
        buildFile();
        file2Data();
    }

    @Override
    String file() {
        return "autoInterval.json";
    }

    @Override
    String data2String() {
        return new Gson().toJson(datas);
    }

    @Override
    void string2Data(String str) {
        if(StringUtils.isNotEmpty(str)) {
            datas = new Gson().fromJson(str, new TypeToken<Map<String, String>>() {
            }.getType());
        }
    }
}
