package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @title: DatagramChannelReceive
 */
public class DatagramChannelReceive {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(8091));
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.clear();
        channel.receive(buf);
        buf.flip();
        while (buf.hasRemaining()) {
            System.out.print((char) buf.get());
        }
        channel.close();
    }
}
