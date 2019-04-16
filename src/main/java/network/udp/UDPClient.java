package network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		InetAddress addr = InetAddress.getLoopbackAddress();
		try (DatagramSocket socket = new DatagramSocket()) {
			socket.connect(addr, 9090);
			String sendMsg = "Hello Server";
			byte[] data = sendMsg.getBytes(StandardCharsets.UTF_8);
			// 将字节流包装成DatagramPacket对象
			DatagramPacket packet = new DatagramPacket(data, data.length);
			socket.send(packet);
			System.out.println("Data was sent.");
			Thread.sleep(1000);

			byte[] buffer = new byte[1024];
			DatagramPacket resp = new DatagramPacket(buffer, buffer.length);
			socket.receive(resp);
			byte[] respData = resp.getData();
			String receiveMsg = new String(respData, 0, resp.getLength(), StandardCharsets.UTF_8);
			System.out.println("客户端接收到的数据为：" + receiveMsg);
		}
	}
}