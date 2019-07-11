package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @title: DatagramChannelSend
 */
public class DatagramChannelSend {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        String info = "I'm the Sender!";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.clear();
        buf.put(info.getBytes());
        buf.flip();
        int bytesSent = channel.send(buf, new InetSocketAddress(8091));
        System.out.println(bytesSent);
        channel.close();
    }
}