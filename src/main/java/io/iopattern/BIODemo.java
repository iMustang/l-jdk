package io.iopattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO的Java实现
 */
public class BIODemo {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket();
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		while (true) {
			Socket socket = serverSocket.accept();
			executorService.submit(new Handler(socket));
		}
	}
}

class Handler implements Runnable {
	private Socket socket;

	Handler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			String str = br.readLine();
			while (str != null) {
				str = br.readLine();
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
