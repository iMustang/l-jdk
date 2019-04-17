package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 带out参数的存储过程，对应脚本为withoutparameter.sql
 *
 * @author xMustang
 */
public class App8 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DbUtil.getConnection();
        String s = "call SP_select_caller3(?) ";
        CallableStatement cst = conn.prepareCall(s);
        cst.registerOutParameter(1, Types.VARCHAR);
        ResultSet rs = cst.executeQuery();
        String id = cst.getString(1);
        System.out.println(id);

        rs.close();
        cst.close();
        conn.close();
    }
}
