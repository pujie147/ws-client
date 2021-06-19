package org.nouk.ws.client.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;

public class RequestIdGen {

    private static AtomicLong   lastId  = new AtomicLong();                                             // 自增id，用于requestId的生成过程
    private static final long   startTimeStamp = System.currentTimeMillis();
    // 启动加载时的时间戳，用于requestId的生成过程
    private static String ip;
    private static String ipHex;

    public static String resolveReqId() throws UnknownHostException {
        if(ip==null) {
            // 规则： hexIp(ip)base36(timestamp)-seq
            ip = InetAddress.getLoopbackAddress().getHostAddress().toString();
        }
        if(ipHex==null){
            ipHex = hexIp(ip);
        }
        return ipHex + Long.toString(startTimeStamp, Character.MAX_RADIX) + "-" + lastId.incrementAndGet();
    }

    // 将ip转换为定长8个字符的16进制表示形式：255.255.255.255 -> FFFFFFFF
    private static String hexIp(String ip) {
        StringBuilder sb = new StringBuilder();
        for (String seg : ip.split("\\.")) {
            String h = Integer.toHexString(Integer.parseInt(seg));
            if (h.length() == 1) sb.append("0");
            sb.append(h);
        }
        return sb.toString();
    }

}
