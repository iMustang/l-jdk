package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Title: TreeSetDemo2
 * @Description: Jdbc update
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 9:50
 */
public class App4 {
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
