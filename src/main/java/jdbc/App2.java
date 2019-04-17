package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Title: App2
 * @Description: 使用DbUtil测试
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 9:48
 */
public class App2 {
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
