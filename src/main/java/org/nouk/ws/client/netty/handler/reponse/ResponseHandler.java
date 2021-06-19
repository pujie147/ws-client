package org.nouk.ws.client.netty.handler.reponse;

import io.netty.handler.codec.http.websocketx.*;
import org.nouk.ws.client.constants.RequestIdEnum;
import org.nouk.ws.client.netty.WebSocketClient;
import org.nouk.ws.client.ui.App;
import org.nouk.ws.client.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 区分response显示为label
 */

@Component
public class ResponseHandler {
    private App app;
    private WebSocketClient webSocketClient;

    @Autowired
    public void setWebSocketClient(WebSocketClient webSocketClient) {
        this.webSocketClient = webSocketClient;
    }
    @Autowired
    public void setApp(App app) {
        this.app = app;
    }

    public void handler(Object msg){
        WebSocketFrame frame = (WebSocketFrame) msg;
        if (frame instanceof TextWebSocketFrame) {
            TextWebSocketFrame textFrame = (TextWebSocketFrame) frame;
            if(textFrame.text().contains(RequestIdEnum.wsClientAuto.name())){
                app.appendResponseAutoTextArea(JsonUtil.toPrettyFormat(textFrame.text()));
            }else{
                app.appendResponseManualTextArea(JsonUtil.toPrettyFormat(textFrame.text()));
            }
            System.out.println("TextWebSocketFrame:"+textFrame.text());
        } else if (frame instanceof BinaryWebSocketFrame) {
            BinaryWebSocketFrame binFrame = (BinaryWebSocketFrame) frame;
            System.out.println("BinaryWebSocketFrame");
        } else if (frame instanceof PongWebSocketFrame) {
            System.out.println("WebSocket Client received pong");
        } else if (frame instanceof CloseWebSocketFrame) {
            System.out.println("receive close frame");
            app.disConnect();
        }
    }


}
