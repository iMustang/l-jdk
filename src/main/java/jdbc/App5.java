package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Title: ArraysAsListDemo
 * @Description: Jdbc select
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 9:51
 */
public class App5 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DbUtil.getConnection();
        String s = "select id from dev where id=?";
        PreparedStatement pst = conn.prepareStatement(s);

        pst.setString(1, "555");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("id"));
        }

        rs.close();
        pst.close();
        conn.close();
    }
}
