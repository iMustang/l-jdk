package io.iopattern;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO的Java实现
 */
public class NIODemo {
	private Selector selector;

	public NIODemo(Selector selector) {
		this.selector = selector;
	}

	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		NIODemo nioDemo = new NIODemo(selector);
		ServerSocketChannel serverSocket = ServerSocketChannel.open();
		serverSocket.socket().bind(new InetSocketAddress(8080));
		serverSocket.configureBlocking(false);
		serverSocket.register(selector, SelectionKey.OP_ACCEPT);
		nioDemo.selector.select();
		Set<SelectionKey> selectionKeys = nioDemo.selector.selectedKeys();
		Iterator<SelectionKey> it = selectionKeys.iterator();
		while (it.hasNext()) {
			nioDemo.dispatch(it.next());
			it.remove();
		}
	}

	private void dispatch(SelectionKey key) throws IOException {
		if (key.isAcceptable()) {
			register(key);
		} else if (key.isReadable()) {
			read(key);
		} else if (key.isWritable()) {
			write(key);
		}
	}

	private void register(SelectionKey key) throws IOException {
		ServerSocketChannel server = (ServerSocketChannel) key.channel();
		SocketChannel accept = server.accept();
		accept.configureBlocking(false);
		accept.register(this.selector, SelectionKey.OP_READ);
	}

	private void read(SelectionKey key) {

	}

	private void write(SelectionKey key) {

	}
}
