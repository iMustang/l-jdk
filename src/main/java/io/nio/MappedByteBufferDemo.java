package io.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @title: MappedByteBufferDemo
 * @description:
 */
public class MappedByteBufferDemo {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL resource = FileChannelDemo.class.getResource("/nio-data.txt");
        RandomAccessFile file = new RandomAccessFile(new File(resource.toURI()), "rw");
        FileChannel fileChannel = file.getChannel();
        MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

        fileChannel.close();
        file.close();
    }
}
