package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  Jdbc select
 */
public class JdbcSelect {
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
