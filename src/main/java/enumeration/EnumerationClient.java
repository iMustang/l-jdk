package enumeration;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * EnumerationClient
 * description:
 * author: xMustang
 * version: 1.0
 * created: 2019/7/12 17:40
 */
public class EnumerationClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress(9091));
		OutputStream os = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(WeekDayEnum.FRI);
		os.close();
		oos.close();
		socket.close();
	}
}
