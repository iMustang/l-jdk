package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Title: App3
 * @Description: JDBC delete
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 9:49
 */
public class App3 {
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
