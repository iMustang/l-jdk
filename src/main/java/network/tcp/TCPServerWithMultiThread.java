package network.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TCP Socket示例——多线程版
 */
public class TCPServerWithMultiThread {
	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newCachedThreadPool();
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(8090);
		System.out.println("TCP server has been ready.");
		while (true) {
			Socket socket = serverSocket.accept();
			Runnable handler = new TimeHandler(socket);
			executor.submit(handler);
		}
	}
}

class TimeHandler implements Runnable {
	private Socket socket;

	TimeHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
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
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}