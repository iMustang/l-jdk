package network.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Title: TCPServer
 * @Description: TCP Socket编程示例——服务端
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 10:01
 */
public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8090);
        System.out.println("TCP server has been ready.");
        Socket socket = serverSocket.accept();
        // 包装读写字节流
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {
                String receiveMsg = reader.readLine();
                System.out.println("接收到客户端的消息是：" + receiveMsg);
                String sendMsg = "Hello Client";
                writer.write(sendMsg + "\n");
                writer.flush();
            }
        }
        socket.close();
        serverSocket.close();
    }
}
