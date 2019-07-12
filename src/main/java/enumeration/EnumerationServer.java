package enumeration;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * EnumerationServer
 * description:
 * author: xMustang
 * version: 1.0
 * created: 2019/7/12 17:46
 */
public class EnumerationServer {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket serverSocket = new ServerSocket(9091);
		Socket socket = serverSocket.accept();
		InputStream is = socket.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		WeekDayEnum day = (WeekDayEnum) ois.readObject();

		// 用值比较方式来对比枚举对象
		if (day == WeekDayEnum.FRI) {
			System.out.println("client Friday enum value is same as server's");
		} else if (day.equals(WeekDayEnum.FRI)) {
			System.out.println("client Friday enum value is equal to server's");
		} else {
			System.out.println("client Friday enum value is not same as server's");
		}

		// 用 switch 方式来比较枚举对象
		switch (day) {
			case MON:
				System.out.println("Do Monday work");
				break;
			case TUE:
				System.out.println("Do Tuesday work");
				break;
			case WED:
				System.out.println("Do Wednesday work");
				break;
			case THU:
				System.out.println("Do Thursday work");
				break;
			case FRI:
				System.out.println("Do Friday work");
				break;
			case SAT:
				System.out.println("Do Saturday work");
				break;
			case SUN:
				System.out.println("Do Sunday work");
				break;
			default:
				System.out.println("I don't know which is day");
				break;
		}

		is.close();
		ois.close();
		socket.close();
		serverSocket.close();
	}
}
