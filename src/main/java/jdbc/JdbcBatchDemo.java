package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Jdbc批处理
 */
public class JdbcBatchDemo {
	public static void main(String[] args) throws SQLException {
		Connection conn = DbUtil.getConnection();
		// 设置事务不自动提交
		conn.setAutoCommit(false);
		Statement st = conn.createStatement();
		st.addBatch("insert into dev(id) values('9999')");
		st.addBatch("insert into dev(id) values('8888')");

		st.executeBatch();
		conn.commit();

		st.close();
		conn.close();
	}
}
