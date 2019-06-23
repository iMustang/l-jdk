package io.nio;

/**
 * @Title: NIOSchema
 * @Description:NIO的大纲
 * http://ifeve.com/overview/
 */
public class NIOSchema {
	/**
	 * Channels
	 * Buffers
	 * Selectors
	 *
	 *
	 * Channels：通道
	 *   通道可以异步地读写。
	 *   通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入。
	 *
	 *   FileChannel：从文件中读写数据
	 *   DatagramChannel：通过UDP读写网络中的数据
	 *   SocketChannel：通过TCP读写网络中的数据
	 *   ServerSocketChannel：监听新进来的TCP连接，对每一个新进来的连接都会创建一个SocketChannel
	 *
	 * Buffers：缓冲区
	 * 	 数据是从通道读入缓冲区，从缓冲区写入到通道中的。
	 *   缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。这块内存被包装成NIO Buffer对象，并提供了一组方法，用来方便的访问该块内存。
	 *
	 * 	 capacity
	 *   position
	 *   limit
	 *
	 *	 使用Buffer读写数据一般遵循以下四个步骤：
	 * 		1. 写入数据到Buffer（Channel的read()、Buffer的put()）
	 * 		2. 调用flip()
	 * 		3. 从Buffer中读取数据（Channel的write()、Buffer的get()）
	 * 		4. 调用clear()或者compact()
	 * 			clear()，将position设回0，limit设置成capacity。Buffer中的数据并未清除，只是这些标记告诉可以从哪里开始往Buffer里写数据。
	 * 		    compact()将所有未读的数据拷贝到Buffer起始处，然后将position设到最后一个未读元素后面，limit设置成capacity。
	 *
	 * 	 ByteBuffer
	 *   ShortBuffer
	 *   CharBuffer
	 *   IntBuffer
	 *   LongBuffer
	 *   FloatBuffer
	 *   DoubleBuffer
	 * 	 MappedByteBuffer
	 *
	 * Scatter/Gather
	 * 	 分散（scatter），从Channel中读操作时将读取的数据写入多个buffer中。
	 *   聚集（gather），写操作时将多个buffer的数据写入同一个Channel。
	 *
	 * Selectors
	 *   Selector（选择器）是NIO中能够检测一到多个NIO通道，并能够知晓通道是否为诸如读写事件做好准备的组件。这样，一个单独的线程可以管理多个Channels
	 *
	 */

	/**
	 * IO与NIO比较
	 * 		IO                	NIO
	 * 		面向流             	面向缓冲
	 * 		阻塞IO				非阻塞IO
	 * 		无                	选择器
	 *
	 * 面向流与面向缓冲
	 * IO是面向流的，NIO是面向缓冲区的。
	 * IO面向流意味着每次从流中读一个或多个字节，直至读取所有字节，它们没有被缓存在任何地方。此外，它不能前后移动流中的数据。如果需要前后移动从流中读取的数据，需要先将它缓存到一个缓冲区。
	 * NIO数据读取到一个它稍后处理的缓冲区，需要时可在缓冲区中前后移动。
	 *
	 * 阻塞与非阻塞IO
	 * IO的各种流是阻塞的。这意味着，当一个线程调用read() 或 write()时，该线程被阻塞，直到有一些数据被读取，或数据完全写入。该线程在此期间不能再干任何事情了。
	 * NIO的非阻塞模式，使一个线程从某通道发送请求读取数据，但是它仅能得到目前可用的数据，如果目前没有数据可用时，就什么都不会获取，而不是保持线程阻塞。所以直至数据变的可以读取之前，该线程可以继续做其他的事情。 非阻塞写也是如此。一个线程请求写入一些数据到某通道，但不需要等待它完全写入，这个线程同时可以去做别的事情。
	 */
}
