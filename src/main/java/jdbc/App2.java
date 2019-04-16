package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * insert demo
 * @author xMustang
 *
 */
public class App2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "insert into dev(id) values(?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, "10000");
		pst.execute();
		
		pst.close();
		conn.close();
	}
}
