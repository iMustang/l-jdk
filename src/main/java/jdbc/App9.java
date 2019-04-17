package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.cj.jdbc.CallableStatement;

/**
 * @Title: App9
 * @Description: Jdbc调用既有入参，又有出参的存储过程，对应sql为withinoutparameter.sql
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 9:55
 */
public class App9 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DbUtil.getConnection();
        String s = "call SP_select_caller4(?,?) ";
        CallableStatement cst = (CallableStatement) conn.prepareCall(s);
        cst.setString(2, "555");
        cst.registerOutParameter(1, Types.VARCHAR);
        ResultSet rs = cst.executeQuery();
        String id = cst.getString(1);
        System.out.println("id:" + id);

        rs.close();
        cst.close();
        conn.close();
    }
}
