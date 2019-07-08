package network.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * CP Socket编程示例——客户端
 */
public class TCPClient {
	public static void main(String[] args) throws IOException {
		InetAddress addr = InetAddress.getLoopbackAddress();
		try (Socket sock = new Socket(addr, 8090)) {

			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8))) {

				try (BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(sock.getOutputStream(), StandardCharsets.UTF_8))) {
					String sendMsg = "Hello Server";
					writer.write(sendMsg + "\n");
					writer.flush();
					// 读取本机8090端口返回的数据
					String receiveMsg = reader.readLine();
					System.out.println("接收到服务端的消息是: " + receiveMsg);
				}
			}
		}
	}
}
