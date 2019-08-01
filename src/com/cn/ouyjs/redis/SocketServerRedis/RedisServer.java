package com.cn.ouyjs.redis.SocketServerRedis;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

/**
 * @author ouyjs
 * @date 2019/8/1 10:10
 * 仿redis_server
 */
public class RedisServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6379);
            Socket socket = serverSocket.accept();
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
