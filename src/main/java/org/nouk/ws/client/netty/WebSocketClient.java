package org.nouk.ws.client.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.nouk.ws.client.netty.handler.WebSocketClientHandler;
import org.nouk.ws.client.netty.handler.request.RequestReplacesContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

@Component
public class WebSocketClient {
    private WebSocketClientHandler webSocketClientHandler;
    @Autowired
    public void setWebSocketClientHandler(WebSocketClientHandler webSocketClientHandler) {
        this.webSocketClientHandler = webSocketClientHandler;
    }

    private Channel channel;

    public boolean connect(String url, HttpHeaders headers) throws URISyntaxException, InterruptedException, SSLException {
        URI websocketURI = new URI(url);
        final String host = websocketURI.getHost();
        final int port;
        final boolean ssl;
        if (websocketURI.getPort() == -1) {
            if ("ws".equalsIgnoreCase(websocketURI.getScheme())) {
                port = 80;
                ssl = false;
            } else if ("wss".equalsIgnoreCase(websocketURI.getScheme())) {
                ssl = true;
                port = 443;
            } else if ("http".equalsIgnoreCase(websocketURI.getScheme())){
                port = 80;
                ssl = false;
            } else if ("https".equalsIgnoreCase(websocketURI.getScheme())){
                ssl = true;
                port = 443;
            }else {
                port = -1;
                ssl = false;
            }
        } else {
            port = websocketURI.getPort();
            ssl = false;
        }
        final SslContext sslCtx;
        if (ssl) {
            sslCtx = SslContextBuilder.forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        } else {
            sslCtx = null;
        }
        HttpHeaders httpHeaders = new DefaultHttpHeaders();
        if(headers!=null) {
            httpHeaders.set(headers);
        }
        EventLoopGroup group=new NioEventLoopGroup();
        Bootstrap boot = new Bootstrap();
        boot.option(ChannelOption.SO_KEEPALIVE,true)
                .option(ChannelOption.TCP_NODELAY,true)
                .group(group)
                .handler(new LoggingHandler(LogLevel.INFO))
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline p = socketChannel.pipeline();
                        if (sslCtx != null) {
                            p.addLast(sslCtx.newHandler(socketChannel.alloc(), host, port));
                        }
                        p.addLast(new ChannelHandler[]{new HttpClientCodec(),
                                new HttpObjectAggregator(1024*1024*10)});
                        p.addLast("hookedHandler", webSocketClientHandler);
                    }
                });
        //进行握手
        WebSocketClientHandshaker handshaker = WebSocketClientHandshakerFactory.newHandshaker(websocketURI, WebSocketVersion.V13, (String)null, true,httpHeaders);
        System.out.println("connect");
        final Channel channel=boot.connect(websocketURI.getHost(),port).sync().channel();
        this.channel = channel;
        WebSocketClientHandler handler = (WebSocketClientHandler)channel.pipeline().get("hookedHandler");
        handler.setHandshaker(handshaker);
        handshaker.handshake(channel);
        //阻塞等待是否握手成功
        handler.handshakeFuture().sync();
        return channel.isActive();
    }

    public boolean disConnect(){
        try {
            return channel.close().await(5, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean sendMessage(String str){
        try {
            return channel.writeAndFlush(new TextWebSocketFrame(str)).await(5, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Channel getChannel() {
        return channel;
    }
}
