package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Title: App11
 * @Description: Jdbc事务
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 9:56
 */
public class App11 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DbUtil.getConnection();
        // 设置事务不自动提交
        conn.setAutoCommit(false);
        Statement st = conn.createStatement();
        String sql = "insert into dev(id) values('19999')";
        try {
            st.execute(sql);
            // 模拟sql执行时出现异常
//            int a = 3 / 0;
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            st.close();
            conn.close();
        }
    }
}
