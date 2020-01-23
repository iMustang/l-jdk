package io.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * PipedStreamTest
 * 管道流测试
 * @author xMustang
 * @version 1.0
 * 2020/1/23 12:59 下午
 */
public class PipedStreamTest {
    public static void main(String[] args) {
        Sender t1 = new Sender();
        Receiver t2 = new Receiver();

        PipedOutputStream out = t1.getOutputStream();
        PipedInputStream in = t2.getInputStream();

        try {
            //管道连接。下面2句话的本质是一样。
            //out.connect(in);
            in.connect(out);

            t1.start();
            t2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
