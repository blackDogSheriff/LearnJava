package com.example.es;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public static final int DEFAULT_PORT = 41152;// 默认8080端口

    public static void start() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("服务器端正在监听端口：" + serverSocket.getLocalPort());
            while (true) {// 死循环时刻监听客户端链接
                final Socket socket = serverSocket.accept();
                System.out.println("建立了与客户端一个新的tcp连接，客户端地址为：" + socket.getInetAddress()
                        + ":" + socket.getPort());
                // 开始服务
                service(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void service(Socket socket) throws Exception {

        // 读取HTTP请求信息
        InputStream socketIn = socket.getInputStream();
        int size = socketIn.available();
        byte[] b = new byte[size];
        socketIn.read(b);
        String request = new String(b);
        System.out.println(request);

        // 解析请求方式、uri、协议，获取uri
        String typeUriHttp = request.substring(0, request.indexOf("\r\n"));
        String uri = typeUriHttp.split(" ")[1];
        // 简化处理响应头content-Type
        String contentType;
        if (uri.indexOf("html") != -1 || uri.indexOf("htm") != -1) {
            contentType = "text/html";
        } else if (uri.indexOf("jpg") != -1 || uri.indexOf("jpeg") != -1) {
            contentType = "image/jpeg";
        } else if (uri.indexOf("gif") != -1) {
            contentType = "image/gif";
        } else
            contentType = "application/octet-stream";

        // 创建HTTP响应结果
        // 创建响应协议、状态
        String httpStatus = "HTTP/1.1 200 OK\r\n";
        // 创建响应头
        String responseHeader = "Content-Type:" + contentType + "\r\n\r\n";
        InputStream in = HttpServer.class.getResourceAsStream("/webRoot" + uri);
        OutputStream socketOut = socket.getOutputStream();
        // 发送响应协议、状态码及响应头、正文
        socketOut.write(httpStatus.getBytes());
        socketOut.write(responseHeader.getBytes());
        int len = 0;
        String jsonString = "{ \"data\": { \"total\": 123, \"success\": 123, \"items\": [ \"a\", \"b\", \"c\", \"d\", \"e\", \"f\", \"g\" ] }, \"message\": \"\", \"error_msg\": \"\", \"error_code\": \"\"}";
        jsonString.getBytes();
        socketOut.write(jsonString.getBytes(), 0, jsonString.getBytes().length);
        // socket.close();
    }
}