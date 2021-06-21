package org.nouk.ws.client.netty.handler.request;

import com.codahale.metrics.Gauge;
import com.google.common.base.Function;
import org.nouk.ws.client.constants.RequestIdEnum;
import org.nouk.ws.client.utils.PlaceholderUtils;
import org.nouk.ws.client.utils.RequestIdGen;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@Component
public class RequestReplacesContent {

    private Map<String, Gauge<String>> map = new HashMap<>();
    @PostConstruct
    private void init() throws UnknownHostException {
        map.put("autoRequestId", ()-> {
            try {
                return RequestIdEnum.wsClientAuto+RequestIdGen.resolveReqId();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            return "";
        });
        map.put("manualRequestId", ()-> {
            try {
                return RequestIdEnum.wsClientManual+RequestIdGen.resolveReqId();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            return "";
        });
    }

    public String replacesContent(String str){
        return PlaceholderUtils.resolvePlaceholders(str, map);
    }


}
