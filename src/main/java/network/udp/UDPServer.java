package network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class UDPServer {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		DatagramSocket socket = new DatagramSocket(9090);
		System.out.println("UDP Server has been ready.");
		while (true) {
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			byte[] data = packet.getData();
			String receiveMsg = new String(data, StandardCharsets.UTF_8);
			System.out.println("Packet received from: " + packet.getSocketAddress() + " : " + receiveMsg);

			String resp = "Hi Client, I receive you";
			packet.setData(resp.getBytes(StandardCharsets.UTF_8));
			socket.send(packet);
		}
	}
}