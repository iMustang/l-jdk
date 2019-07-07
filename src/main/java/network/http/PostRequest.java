package network.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Http POST 请求示例
 */
public class PostRequest {
	public static void main(String[] args) throws IOException {
		String urlStr = "http://fanyi.youdao.com/openapi.do";
		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 添加请求属性
		connection.addRequestProperty("encoding", "UTF-8");
		// 允许输入
		connection.setDoInput(true);
		// 允许输出
		connection.setDoOutput(true);

		connection.setRequestMethod("POST");

		try (BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(connection.getOutputStream()))) {
			bw.write("keyfrom=wjy-test&key=36384249&type=data&doctype=xml&version=1.1&q=welcome");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(connection.getInputStream()))) {
			String readLine;
			StringBuilder sb = new StringBuilder();
			while ((readLine = br.readLine()) != null) {
				sb.append(readLine);
			}
			System.out.println("收到的响应是：" + sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
