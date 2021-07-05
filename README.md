# ws-client

[![Author](https://img.shields.io/badge/Author-nouk-red.svg "Author")](https://github.com/pujie147 "Author")
[![LICENSE](https://img.shields.io/github/license/JoeyBling/hexo-theme-yilia-plus "LICENSE")](./LICENSE "LICENSE")

本app实用java gui实现的websocket服务器调式软件，用户调式服务协议是否异常也可以在开发过程中调试。

本项目支持包含以下内容：
- 协议： ws、wss
- 支持数据结构：json 
- 支持协议持久化
- 支持消息定时发送
- 支持更具文件夹名称定时app名称
- 支持headers设置

## 内容列表

- [背景](#背景)
- [安装](#安装)
- [使用说明](#使用说明)
- [如何贡献](#如何贡献)
- [使用许可](#使用许可)

## 背景

在websocket开发过程中，调试起来比较麻烦。在网上搜索到一个websocket-man，用起来不方便并且不给源码所有自己做了一个。

这个项目的目标是：

1. 在调试的时候方便。
2. 支持多种协议，如：json、protobuf、hex 等。
3. 添加reponse解析等功能。
4. 添加http rest client 功能。

## 安装

[发布](https://github.com/pujie147/ws-client/releases/tag/v.1.0.0) 中有 jar和win版两种。jar需要jdk，win可以在window上直接使用。

## 使用说明

下载jar到定义目录下，直接使用jdk打开即刻使用。

![image-20210705162528017](https://raw.githubusercontent.com/pujie147/ws-client/main/README.assets/image-20210705162528017.png)

- `.wsClient`文件存放持久化数据
- app会更具文件夹名称定义app名字（**win版不支持**）
- `${manualRequestId}`  是定义手动发送的requestId
- `${autoRequestId}`是定义自动发送的requestId

如果response消息内没有`${autoRequestId}` 则消息会出现在 `manual-send` 标签内的消息区域。

![image-20210705182226795](https://raw.githubusercontent.com/pujie147/ws-client/main/README.assets/image-20210705182226795.png)



## 如何贡献

非常欢迎你的加入！[提一个 Issue](https://github.com/pujie147/ws-client/issues/new) 或者提交一个 Pull Request。



## 使用许可

[MIT](LICENSE) © Richard Littauer


