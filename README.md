# ws-client
ws-client 是一款websocket调试软件，用户调试开发websocket服务。

目前支持：
- 协议： ws、wss
- 支持数据结构：json 
- 支持协议持久化
- 支持消息定时发送
- 支持更具文件夹名称定时app名称
- 支持headers设置



![image-20210705162239665](https://raw.githubusercontent.com/pujie147/ws-client/main/README.assets/image-20210705162239665.png)





### 使用说明:

下载jar到定义目录下，直接使用jdk打开即刻使用。

![image-20210705162528017](https://raw.githubusercontent.com/pujie147/ws-client/main/README.assets/image-20210705162528017.png)

- `.wsClient`文件存放持久化数据
- app会更具文件夹名称定义app名字（方便多开）
- `${manualRequestId}`  是定义手动发送的requestId
- `${autoRequestId}`是定义自动发送的requestId

如果response消息内没有`${autoRequestId}` 则消息会出现在 `manual-send` 标签内的消息区域。