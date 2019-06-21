package commonio;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Title: HashMapTraverse
 * @Description: Apache common-io常用方法使用
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/5/5 20:20
 */
public class App1 {
    public static void main(String[] args) throws IOException {
        String doc = FileUtils.readFileToString(new File("F:\\a.txt"), Charset.forName("GBK"));
        System.out.println(doc);

        FileUtils.writeStringToFile(new File("F:\\b.txt"), "今天天气很好", Charset.forName("UTF8"));

        LineIterator it = FileUtils.lineIterator(new File("F:\\c.txt"), "GBK");
        while(it.hasNext()){
            System.out.println(it.nextLine());
        }
        LineIterator.closeQuietly(it);
    }
}
