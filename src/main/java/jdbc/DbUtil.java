package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 给APP2等之后类使用的数据库连接工具类
 * 
 * @author xMustang
 *
 */
public class DbUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private static Connection conn = null;

	static {
		try {
			// 1.加载驱动程序
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.获得数据库的连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 返回数据库连接
	public static Connection getConnection() {
		return conn;
	}
}
