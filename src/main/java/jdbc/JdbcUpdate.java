package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Jdbc update
 */
public class JdbcUpdate {
	public static void main(String[] args) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "update dev set id=? where id=10000";
		PreparedStatement pst = conn.prepareStatement(sql);

		pst.setString(1, "555");
		pst.execute();

		pst.close();
		conn.close();
	}
}
