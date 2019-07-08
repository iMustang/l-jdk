package jdbc.jdbcpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) throws SQLException {
		// 获得数据库连接对象
		Connection conn = JdbcUtil.getConnection();
		Statement smt = conn.createStatement();
		String sql = "select id from dev";
		ResultSet rs = smt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("id"));
		}
		// 关闭所有的数据库资源
		JdbcUtil.release(conn, smt, rs);
	}
}
