package org.nouk.ws.client.data;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ManualListModel extends DataPersistence {

    private Map<String,String> datas = new LinkedHashMap();

    public int getSize() {
        if (datas==null) {
            return 0;
        }
        return datas.keySet().size();
    }

    public Object getElementAt(int index) {
        return datas.keySet().stream().collect(Collectors.toList()).get(index);
    }

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
    }

    @Override
    String file() {
        return "manual.json";
    }

    public Map<String, String> getDatas() {
        return datas;
    }

    @Override
    String data2String() {
        return new Gson().toJson(datas);
    }

    @Override
    void string2Data(String str) {
        datas = new Gson().fromJson(str,new TypeToken<Map<String,String>>(){}.getType());
    }
}
