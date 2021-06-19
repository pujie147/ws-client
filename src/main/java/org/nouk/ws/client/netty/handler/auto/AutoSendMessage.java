package org.nouk.ws.client.netty.handler.auto;

public class AutoSendMessage {
    private String requestBody;
    private Integer intervalTime;

    public AutoSendMessage(String requestBody, Integer intervalTime) {
        this.requestBody = requestBody;
        this.intervalTime = intervalTime;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public Integer getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(Integer intervalTime) {
        this.intervalTime = intervalTime;
    }
}
