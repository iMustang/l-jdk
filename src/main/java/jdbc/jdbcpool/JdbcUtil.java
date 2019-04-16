package jdbc.jdbcpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 进一步封装数据库操作的一些方法
 * 
 * @author xMustang
 *
 */
public class JdbcUtil {

	// 数据库连接池
	private static JdbcConnectionsPool pool = new JdbcConnectionsPool();

	// 获取数据库连接
	public static Connection getConnection() throws SQLException {
		return pool.getConnection();
	}

	// 释放资源
	public static void release(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}