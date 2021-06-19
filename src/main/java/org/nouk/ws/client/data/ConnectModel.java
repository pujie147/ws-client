package org.nouk.ws.client.data;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class ConnectModel extends DataPersistence {
    @PostConstruct
    private void init() throws IOException {
        buildFile();
    }

    @Override
    String file() {
        return "connect.json";
    }

    @Override
    String data2String() {
        return null;
    }

    @Override
    void string2Data(String str) {

    }
}
