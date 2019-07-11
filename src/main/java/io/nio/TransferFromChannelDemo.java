package io.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;

/**
 * FileChannel的transferFrom()
 * <p>
 * transferForm()将数据从其他通道传输到FileChannel
 * <p>
 * 在SoketChannel的实现中，SocketChannel只会传输此刻准备好的数据，因此，SocketChannel可能不会将请求的所有数据全部传输到FileChannel中。
 */
public class TransferFromChannelDemo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL from = TransferFromChannelDemo.class.getResource("/fromFile.txt");
        URL to = TransferFromChannelDemo.class.getResource("/toFile.txt");

        RandomAccessFile fromFile = new RandomAccessFile(new File(from.toURI()), "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile(new File(to.toURI()), "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        toChannel.transferFrom(fromChannel, position, count);

    }
}
