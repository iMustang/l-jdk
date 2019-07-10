package io.iopattern.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NIOMultiReactor
 * description:Reactor实现服务器三：
 * 多Reactor
 */
public class NIOMultiReactor {

	/**
	 * Netty使用的Reactor模式，引入了多Reactor。
	 * 也即一个主Reactor负责监控所有的连接请求，多个子Reactor负责监控并处理读/写请求，减轻了主Reactor的压力，降低了主Reactor压力太大而造成的延迟。
	 * <p>
	 * 并且每个子Reactor分别属于一个独立的线程，每个成功连接后的Channel的所有操作由同一个线程处理。这样保证了同一请求的所有状态和上下文在同一个线程中，避免了不必要的上下文切换，同时也方便了监控请求响应状态。
	 */
	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.bind(new InetSocketAddress(8090));

		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		int corNum = Runtime.getRuntime().availableProcessors();
		MyProcessor[] myProcessors = new MyProcessor[2 * corNum];
		for (int i = 0; i < myProcessors.length; i++) {
			myProcessors[i] = new MyProcessor();
		}

		int index = 0;
		while (selector.select() > 0) {
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
					MyProcessor myProcessor = myProcessors[(index++) % corNum];
					myProcessor.addChannel(socket);
					myProcessor.wakeup();
				}
			}
		}
	}
}

class MyProcessor {
	private static final ExecutorService SERVICE =
			Executors.newFixedThreadPool(2 * Runtime.getRuntime().availableProcessors());
	private Selector selector;

	MyProcessor() throws IOException {
		this.selector = SelectorProvider.provider().openSelector();
		start();
	}

	void addChannel(SocketChannel socketChannel) throws ClosedChannelException {
		socketChannel.register(this.selector, SelectionKey.OP_READ);
	}

	void wakeup() {
		this.selector.wakeup();
	}

	private void start() {
		SERVICE.submit(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						if (selector.select(500) <= 0) {
							continue;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

					Set<SelectionKey> keys = selector.selectedKeys();
					Iterator<SelectionKey> it = keys.iterator();
					while (it.hasNext()) {
						SelectionKey key = it.next();
						it.remove();
						if (key.isReadable()) {
							ByteBuffer buffer = ByteBuffer.allocate(1024);
							SocketChannel socket = (SocketChannel) key.channel();
							try {
								int count = socket.read(buffer);
								if (count < 0) {
									socket.close();
									key.cancel();
									System.out.println("Read ended: " + socket);
									continue;
								} else if (count == 0) {
									System.out.println("Message size is 0 : " + socket);
									continue;
								} else {
									System.out.println("Read message: " + new String(buffer.array()));
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		});
	}
}
