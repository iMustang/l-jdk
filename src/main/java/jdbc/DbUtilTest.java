package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用DbUtil测试
 */
public class DbUtilTest {
	public static void main(String[] args) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "insert into dev(id) values(?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, "10000");
		pst.execute();

		pst.close();
		conn.close();
	}
}
