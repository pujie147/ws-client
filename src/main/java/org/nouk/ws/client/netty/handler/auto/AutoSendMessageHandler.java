package org.nouk.ws.client.netty.handler.auto;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;
//import org.nouk.netty.client.RequestIdGen;

import javax.swing.*;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class AutoSendMessageHandler {
    private static Map<JPanel, Fiber> autoSendTasks = new HashMap<>();

    private static final String AutoSendHeadTag = "AUTO_SEND";

    private static boolean isAutoSend(String requestId){
        return requestId.startsWith(AutoSendHeadTag);
    }

    private static String resolveReqId() throws UnknownHostException {
//        return AutoSendHeadTag+"-"+ RequestIdGen.resolveReqId();
        return null;
    }

    public static void buildAutoSendMessage(JPanel jPanel,String requestBody,Integer intervalTime){
        Fiber fiber = new Fiber<Void>(jPanel.getName(),new SuspendableRunnable() {
            public void run() throws SuspendExecution, InterruptedException {
                for (;;) {
                    Fiber.sleep(intervalTime);
//                    if (WebSocketClient.getInstance() == null) {
//                        break;
//                    }
//                    System.out.println(System.currentTimeMillis() / 1000 + "--" + requestBody);
//                    WebSocketClient.getInstance().getChannel().writeAndFlush(new TextWebSocketFrame(requestBody));
                }
            }
        }).start();
        autoSendTasks.put(jPanel,fiber);
    }

    public static void killTask(JPanel jPanel){
        autoSendTasks.get(jPanel).cancel(true);
    }

}
