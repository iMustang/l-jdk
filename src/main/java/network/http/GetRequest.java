package network.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @Title: GetRequest
 * @Description: Http GET请求示例
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 9:59
 */
public class GetRequest {
    public static void main(String[] args) throws IOException {
        String urlStr = "http://fanyi.youdao.com/openapi.do?keyfrom=wjy-test&key=36384249&type=data&doctype=jsonp&callback=show&version=1.1&q=hello";
        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();

        // 输入流读取请求返回的响应
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));) {
            String readLine = null;
            StringBuilder sb = new StringBuilder();

            while ((readLine = br.readLine()) != null) {
                sb.append(readLine);
            }
            System.out.println("收到的响应为：" + sb);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
