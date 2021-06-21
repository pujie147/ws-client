package org.nouk.ws.client.netty.handler.auto;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.nouk.ws.client.data.AutoListModel;
import org.nouk.ws.client.netty.WebSocketClient;
import org.nouk.ws.client.netty.handler.request.RequestReplacesContent;
import org.nouk.ws.client.ui.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class AutoSendMessageHandler {
    private WebSocketClient webSocketClient;
    private App app;
    private RequestReplacesContent requestReplacesContent;

    @Autowired
    public void setWebSocketClient(WebSocketClient webSocketClient) {
        this.webSocketClient = webSocketClient;
    }
    @Autowired
    public void setApp(App app) {
        this.app = app;
    }
    @Autowired
    public void setRequestReplacesContent(RequestReplacesContent requestReplacesContent) {
        this.requestReplacesContent = requestReplacesContent;
    }

    private Map<String, Fiber> autoSendTasks = new HashMap<>();

    public void buildAutoSendMessage(String key,String requestBody,Integer intervalTime){
        Fiber fiber = new Fiber<Void>(key,new SuspendableRunnable() {
            public void run() throws SuspendExecution, InterruptedException {
                for (;;) {
                    Fiber.sleep(intervalTime, TimeUnit.SECONDS);
                    String requstMessage = requestReplacesContent.replacesContent(requestBody);
                    if(webSocketClient.sendMessage(requstMessage)){
                        app.appendRequestAutoTextArea(requstMessage);
                    }
                }
            }
        }).start();
        autoSendTasks.put(key,fiber);
    }

    public void killTask(String key){
        autoSendTasks.get(key).cancel(true);
    }

}
