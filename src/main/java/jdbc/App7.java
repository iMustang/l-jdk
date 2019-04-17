package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Title: App7
 * @Description: Jdbc调用带参数存储过程，对应withinparameter.sql
 * @Version: 1.0
 * @create: 2019/4/17 9:52
 */
public class App7 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DbUtil.getConnection();
        String s = "call SP_select_caller2(?) ";
        CallableStatement cst = conn.prepareCall(s);
        cst.setString(1, " ");
        ResultSet rs = cst.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("id"));
        }
        System.out.println("*******************************");

        String s1 = "call SP_select_caller2(?)";
        CallableStatement cst1 = conn.prepareCall(s1);
        cst1.setString(1, "555");
        ResultSet rs1 = cst1.executeQuery();

        while (rs1.next()) {
            System.out.println(rs1.getString("id"));
        }

        rs1.close();
        cst1.close();
        rs.close();
        cst.close();

        conn.close();
    }
}
