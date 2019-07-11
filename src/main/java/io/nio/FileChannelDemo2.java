package io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @title: FileChannelDemo2
 * @description: FileInputStream获取Channel
 */
public class FileChannelDemo2 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL resource = FileChannelDemo.class.getResource("/nio-data.txt");
        FileInputStream fis = new FileInputStream(new File(resource.toURI()));

        FileChannel fileChannel = fis.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();

        int count = fileChannel.read(buffer);
        while (count != -1) {
            System.out.println("Read " + count);

            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            count = fileChannel.read(buffer);
        }

        fileChannel.close();
        fis.close();

    }
}
