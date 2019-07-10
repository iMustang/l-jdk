package io.iopattern.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NIOServerMultiThread
 * description:Reactor实现服务器二：
 * 多工作线程Reactor模式
 * 将对新连接的处理和读/写操作的处理放在了不同的线程中，读/写操作不再阻塞对新连接请求的处理。
 */
public class NIOServerMultiThread {
	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.bind(new InetSocketAddress(8090));
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (true) {
			if (selector.selectNow() < 0) {
				continue;
			}
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> it = keys.iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				it.remove();
				if (key.isAcceptable()) {
					ServerSocketChannel serverSocket = (ServerSocketChannel) key.channel();
					SocketChannel socket = serverSocket.accept();
					socket.configureBlocking(false);
					System.out.println("Accept request from: " + socket.getRemoteAddress());
					SelectionKey readKey = socket.register(selector, SelectionKey.OP_READ);
					readKey.attach(new Processor());
				} else if (key.isReadable()) {
					Processor processor = (Processor) key.attachment();
					processor.process(key);
				}
			}
		}
	}
}

class Processor {
	private static final ExecutorService SERVICE;

	static {
		SERVICE = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}

	public void process(final SelectionKey selectionKey) {
		SERVICE.submit(new Runnable() {
			@Override
			public void run() {
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				SocketChannel socket = (SocketChannel) selectionKey.channel();
				try {
					int count = socket.read(buffer);
					if (count < 0) {
						socket.close();
						selectionKey.cancel();
						System.out.println("Read ended: " + socket);
						return;
					} else if (count == 0) {
						return;
					}
					System.out.println("Read message: " + new String(buffer.array()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
