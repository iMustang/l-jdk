package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC delete
 */
public class JdbcDelete {
	public static void main(String[] args) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "delete from dev where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);

		pst.setString(1, "100");

		pst.execute();
		pst.close();
		conn.close();
	}
}
