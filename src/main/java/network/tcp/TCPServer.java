package network.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * TCP Socket编程示例——服务端
 */
public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8090);
        System.out.println("TCP server has been ready.");
        while (true) {
            Socket socket = serverSocket.accept();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {

                try (BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {
                    String recMsg = reader.readLine();
                    System.out.println();
                    System.out.println("接收到客户端的消息是：" + recMsg);
                    System.out.println("客户端接收消息完成");
                    String sendMsg = "Hello Client";
                    writer.write(sendMsg + "\n");
                    writer.flush();
                }
            }
            socket.close();
        }
    }
}
