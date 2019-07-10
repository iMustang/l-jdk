package io.iopattern.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * NIOServer
 * description: Reactor实现服务器一：
 * 经典Reactor模式
 */
public class NIOServer {
	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.bind(new InetSocketAddress(8090));

		//socketServerChannel对象只注册了OP_ACCEPT事件
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (selector.select() > 0) {
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> it = keys.iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				if (key.isAcceptable()) {
					ServerSocketChannel serverSocket = (ServerSocketChannel) key.channel();
					SocketChannel socket = serverSocket.accept();
					socket.configureBlocking(false);

					// socketChannel对象只注册了OP_READ事件
					socket.register(selector, SelectionKey.OP_READ);
					System.out.println("Accept request from: " + socket.getRemoteAddress());
				} else if (key.isReadable()) {
					SocketChannel socket = (SocketChannel) key.channel();
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					int count = socket.read(buffer);
					if (count <= 0) {
						socket.close();
						key.cancel();
						System.out.println("Received invalide data, close the connection");
						continue;
					}
					System.out.println("Received message : " + new String(buffer.array()));
				}
				it.remove();
			}
		}

	}
}
