package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Jdbc调用无参数存储过程，对应脚本noparameter.sql
 */
public class JdbcCallStatementDemo1 {
	public static void main(String[] args) throws SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "call SP_select_caller1() ";
		CallableStatement cst = conn.prepareCall(sql);
		ResultSet rs = cst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("id"));
		}

		cst.close();
		conn.close();
	}
}
