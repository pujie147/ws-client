package org.nouk.ws.client;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.io.*;
import java.util.Map;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> {
            System.out.println(key + "---" + value);
        });
        String userHome = System.getProperty("user.home");// userHome 是 C:\Users\用户名
        String userDir = System.getProperty("user.dir");// userDir 工程项目目录
        System.out.println(userHome);
        System.out.println(userDir);
        System.out.println("-------------------------");
        Map<String, String> map = System.getenv();
        map.forEach((key, value) -> {
            System.out.println(key + "---" + value);
        });
        String userName = System.getenv("USERNAME");// userName 用户名称
        System.out.println(userName);
    }
}