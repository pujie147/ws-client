package org.nouk.ws.client.data;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AutoListModel extends DataPersistence {
    private Map<String,String> datas = new LinkedHashMap();
    private Map<String,Boolean> active = new LinkedHashMap();

    public int getSize() {
        if (datas==null) {
            return 0;
        }
        return datas.keySet().size();
    }

    public Object getElementAt(int index) {
        List<String> collect = datas.keySet().stream().collect(Collectors.toList());
        String key = collect.get(index);
        if (this.active.containsKey(key) && this.active.get(key)) {
            return key + "     " + "↑";
        }
        return key;
    }

    public void setActive(String string,boolean b) {
        this.active.put(string,b);
    }

    public void addData(String key, String data){
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
        return "auto.json";
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
