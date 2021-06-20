package org.nouk.ws.client.data;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ConnectModel extends DataPersistence {
    private String connectionUrl = "";
    private Map<String,String> headers = new LinkedHashMap<>();

    @PostConstruct
    private void init() throws IOException {
        buildFile();
        file2Data();
    }

    @Override
    String file() {
        return "connect.json";
    }

    @Override
    String data2String() {
        return new Gson().toJson(this);
    }

    @Override
    void string2Data(String str) {
        if (StringUtils.isNoneEmpty(str)) {
            ConnectModel connectModel = new Gson().fromJson(str,ConnectModel.class);
            this.connectionUrl = connectModel.connectionUrl;
            this.headers = connectModel.headers;
        }
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
