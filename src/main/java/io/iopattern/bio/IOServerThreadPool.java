package io.iopattern.bio;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * IOServerThreadPool
 * description:BIO下的服务器实现三：
 * 使用线程池处理请求。为了防止连接请求过多，导致服务器创建的线程数过多，造成过多线程上下文切换的开销。可以通过线程池来限制创建的线程数。
 */
public class IOServerThreadPool {
	public static void main(String[] args) throws IOException {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress(8090));
		while (true) {
			final Socket socket = serverSocket.accept();
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					InputStream is = null;
					//为突显重要代码，省略了关闭资源的代码，可使用try-catch-source
					try {
						is = socket.getInputStream();
						System.out.println(IOUtils.toString(is, Charset.forName("UTF-8")));
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});
		}
	}
}
