package io.nio;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @title: GatterDemo
 */
public class GatterDemo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        ByteBuffer header = ByteBuffer.allocate(10);
        ByteBuffer body = ByteBuffer.allocate(10);
        byte[] b1 = {'0', '1'};
        byte[] b2 = {'2', '3'};
        header.put(b1);
        body.put(b2);
        ByteBuffer[] buffs = {header, body};
        URL resource = FileChannelDemo.class.getResource("/nio-data.txt");
        FileOutputStream fos = new FileOutputStream(new File(resource.toURI()));
        FileChannel channel = fos.getChannel();
        channel.write(buffs);

        channel.close();
        fos.close();
    }
}
